/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package yaooqinn.kyuubi.server

import java.util.{List => JList, Map => JMap}

import org.apache.hive.service.auth.HiveAuthFactory
import org.apache.hive.service.cli._
import org.apache.hive.service.cli.thrift.TProtocolVersion
import org.apache.spark.{SparkConf, SparkException}

import yaooqinn.kyuubi.Logging
import yaooqinn.kyuubi.operation.KyuubiSQLOperation
import yaooqinn.kyuubi.service.CompositeService
import yaooqinn.kyuubi.session.KyuubiSessionManager

private[server] class KyuubiServerCLIService private(
    name: String,
    private val thriftServer: KyuubiServer)
  extends CompositeService(name) with ICLIService with Logging {

  private[this] var sessionManager: KyuubiSessionManager = _
  def getSessionManager: KyuubiSessionManager = sessionManager

  def this(thriftServer: KyuubiServer) = {
    this(classOf[KyuubiServerCLIService].getSimpleName, thriftServer)
  }

  override def init(conf: SparkConf): Unit = synchronized {
    this.conf = conf
    sessionManager = new KyuubiSessionManager(thriftServer)
    addService(sessionManager)
    super.init(conf)
  }

  override def start(): Unit = {
    super.start()
  }

  def openSession(
      protocol: TProtocolVersion,
      username: String,
      password: String,
      ipAddress: String,
      configuration: JMap[String, String]): SessionHandle = {
    val sessionHandle = sessionManager.openSession(
      protocol, username, password, ipAddress, configuration, withImpersonation = false)
    sessionHandle
  }

  def openSessionWithImpersonation(
      protocol: TProtocolVersion,
      username: String,
      password: String,
      ipAddress: String,
      configuration: JMap[String, String],
      delegationToken: String): SessionHandle = {
    val sessionHandle = sessionManager.openSession(
      protocol, username, password, ipAddress, configuration, withImpersonation = true)
    sessionHandle
  }

  override def closeSession(sessionHandle: SessionHandle): Unit = {
    sessionManager.closeSession(sessionHandle)
  }

  override def getInfo(sessionHandle: SessionHandle, infoType: GetInfoType): GetInfoValue = {
    sessionManager.getSession(sessionHandle).getInfo(infoType)
  }

  override def executeStatement(
      sessionHandle: SessionHandle,
      statement: String,
      confOverlay: JMap[String, String]): OperationHandle = {
    sessionManager.getSession(sessionHandle).executeStatement(statement, confOverlay)
  }

  override def executeStatementAsync(
      sessionHandle: SessionHandle,
      statement: String,
      confOverlay: JMap[String, String]): OperationHandle = {
    sessionManager.getSession(sessionHandle).executeStatementAsync(statement, confOverlay)
  }

  override def getTypeInfo(sessionHandle: SessionHandle): OperationHandle = {
    throw new HiveSQLException("Method Not Implemented!")
  }

  override def getCatalogs(sessionHandle: SessionHandle): OperationHandle = {
    throw new HiveSQLException("Method Not Implemented!")
  }

  override def getSchemas(
      sessionHandle: SessionHandle, catalogName: String, schemaName: String): OperationHandle = {
    throw new HiveSQLException("Method Not Implemented!")
  }

  override def getTables(
      sessionHandle: SessionHandle,
      catalogName: String,
      schemaName: String,
      tableName: String,
      tableTypes: JList[String]): OperationHandle = {
    throw new HiveSQLException("Method Not Implemented!")
  }

  override def getTableTypes(sessionHandle: SessionHandle): OperationHandle = {
    throw new HiveSQLException("Method Not Implemented!")
  }

  override def getColumns(
      sessionHandle: SessionHandle,
      catalogName: String,
      schemaName: String, tableName: String, columnName: String): OperationHandle = {
    throw new HiveSQLException("Method Not Implemented!")
  }

  override def getFunctions(
      sessionHandle: SessionHandle,
      catalogName: String,
      schemaName: String, functionName: String): OperationHandle = {
    throw new HiveSQLException("Method Not Implemented!")
  }

  override def getOperationStatus(opHandle: OperationHandle): OperationStatus = {
    sessionManager.getOperationManager.getOperation(opHandle).getStatus
  }

  override def cancelOperation(opHandle: OperationHandle): Unit = {
    sessionManager.getOperationManager.getOperation(opHandle).cancel()
  }

  override def closeOperation(opHandle: OperationHandle): Unit = {
    sessionManager.getOperationManager.getOperation(opHandle).close()
  }

  override def getResultSetMetadata(opHandle: OperationHandle): TableSchema = {
    sessionManager.getOperationManager.getOperation(opHandle).getResultSetSchema
  }

  override def fetchResults(opHandle: OperationHandle): RowSet = {
    fetchResults(opHandle, KyuubiSQLOperation.DEFAULT_FETCH_ORIENTATION,
      KyuubiSQLOperation.DEFAULT_FETCH_MAX_ROWS, FetchType.QUERY_OUTPUT)
  }

  override def fetchResults(
      opHandle: OperationHandle,
      orientation: FetchOrientation,
      maxRows: Long,
      fetchType: FetchType): RowSet = {
    sessionManager.getOperationManager.getOperation(opHandle)
      .getParentSession.fetchResults(opHandle, orientation, maxRows, fetchType)

  }
}

object KyuubiServerCLIService {
  final val SERVER_VERSION = TProtocolVersion.HIVE_CLI_SERVICE_PROTOCOL_V8
}
