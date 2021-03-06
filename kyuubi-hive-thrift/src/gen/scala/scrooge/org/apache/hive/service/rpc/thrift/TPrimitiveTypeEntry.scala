/**
 * Generated by Scrooge
 *   version: 19.12.0
 *   rev: dfdb68cf6b9c501dbbe3ae644504bf403ad76bfa
 *   built at: 20191212-171820
 */
package org.apache.hive.service.rpc.thrift

import com.twitter.io.Buf
import com.twitter.scrooge.{
  InvalidFieldsException,
  LazyTProtocol,
  StructBuilder,
  StructBuilderFactory,
  TFieldBlob,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructField,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ValidatingThriftStruct,
  ValidatingThriftStructCodec3
}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.TMemoryBuffer
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.reflect.{ClassTag, classTag}


object TPrimitiveTypeEntry extends ValidatingThriftStructCodec3[TPrimitiveTypeEntry] with StructBuilderFactory[TPrimitiveTypeEntry] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct: TStruct = new TStruct("TPrimitiveTypeEntry")
  val TypeField: TField = new TField("type", TType.ENUM, 1)
  val TypeFieldI32: TField = new TField("type", TType.I32, 1)
  val TypeFieldManifest: Manifest[org.apache.hive.service.rpc.thrift.TTypeId] = implicitly[Manifest[org.apache.hive.service.rpc.thrift.TTypeId]]
  val TypeQualifiersField: TField = new TField("typeQualifiers", TType.STRUCT, 2)
  val TypeQualifiersFieldManifest: Manifest[org.apache.hive.service.rpc.thrift.TTypeQualifiers] = implicitly[Manifest[org.apache.hive.service.rpc.thrift.TTypeQualifiers]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      TypeField,
      false,
      true,
      TypeFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      TypeQualifiersField,
      true,
      false,
      TypeQualifiersFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  private val fieldTypes: IndexedSeq[ClassTag[_]] = IndexedSeq(
    classTag[org.apache.hive.service.rpc.thrift.TTypeId].asInstanceOf[ClassTag[_]],
    classTag[_root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers]].asInstanceOf[ClassTag[_]]
  )

  private[this] val structFields: Seq[ThriftStructField[TPrimitiveTypeEntry]] = {
    Seq(
      new ThriftStructField[TPrimitiveTypeEntry](
        TypeField,
        _root_.scala.Some(TypeFieldManifest),
        classOf[TPrimitiveTypeEntry]) {
          def getValue[R](struct: TPrimitiveTypeEntry): R = struct.`type`.asInstanceOf[R]
      },
      new ThriftStructField[TPrimitiveTypeEntry](
        TypeQualifiersField,
        _root_.scala.Some(TypeQualifiersFieldManifest),
        classOf[TPrimitiveTypeEntry]) {
          def getValue[R](struct: TPrimitiveTypeEntry): R = struct.typeQualifiers.asInstanceOf[R]
      }
    )
  }

  override lazy val metaData: ThriftStructMetaData[TPrimitiveTypeEntry] =
    new ThriftStructMetaData(this, structFields, fieldInfos, Seq(), structAnnotations)

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: TPrimitiveTypeEntry): Unit = {
    if (_item.`type` == null) throw new TProtocolException("Required field `type` cannot be null")
  }

  /**
   * Checks that the struct is a valid as a new instance. If there are any missing required or
   * construction required fields, return a non-empty list.
   */
  def validateNewInstance(item: TPrimitiveTypeEntry): scala.Seq[com.twitter.scrooge.validation.Issue] = {
    val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]

    if (item.`type` == null)
      buf += com.twitter.scrooge.validation.MissingRequiredField(fieldInfos.apply(0))
    buf ++= validateField(item.`type`)
    buf ++= validateField(item.typeQualifiers)
    buf.toList
  }

  def withoutPassthroughFields(original: TPrimitiveTypeEntry): TPrimitiveTypeEntry =
    new Immutable(
      `type` =
        {
          val field = original.`type`
          field
        },
      typeQualifiers =
        {
          val field = original.typeQualifiers
          field.map { field =>
            org.apache.hive.service.rpc.thrift.TTypeQualifiers.withoutPassthroughFields(field)
          }
        }
    )

  def newBuilder(): StructBuilder[TPrimitiveTypeEntry] = new TPrimitiveTypeEntryStructBuilder(_root_.scala.None, fieldTypes)

  override def encode(_item: TPrimitiveTypeEntry, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): TPrimitiveTypeEntry = {

    var `type`: org.apache.hive.service.rpc.thrift.TTypeId = null
    var _got_type = false
    var typeQualifiers: Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers] = None

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.I32 | TType.ENUM =>
    
                `type` = readTypeValue(_iprot)
                _got_type = true
              case _actualType =>
                val _expectedType = TType.ENUM
                throw new TProtocolException(
                  "Received wrong type for field '`type`' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRUCT =>
    
                typeQualifiers = Some(readTypeQualifiersValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'typeQualifiers' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_type) throw new TProtocolException("Required field '`type`' was not found in serialized data for struct TPrimitiveTypeEntry")
    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      `type`,
      typeQualifiers,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): TPrimitiveTypeEntry =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[thrift] def eagerDecode(_iprot: TProtocol): TPrimitiveTypeEntry = {
    var `type`: org.apache.hive.service.rpc.thrift.TTypeId = null
    var _got_type = false
    var typeQualifiers: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers] = _root_.scala.None
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.I32 | TType.ENUM =>
                `type` = readTypeValue(_iprot)
                _got_type = true
              case _actualType =>
                val _expectedType = TType.ENUM
                throw new TProtocolException(
                  "Received wrong type for field '`type`' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRUCT =>
                typeQualifiers = _root_.scala.Some(readTypeQualifiersValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'typeQualifiers' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_type) throw new TProtocolException("Required field '`type`' was not found in serialized data for struct TPrimitiveTypeEntry")
    new Immutable(
      `type`,
      typeQualifiers,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    `type`: org.apache.hive.service.rpc.thrift.TTypeId,
    typeQualifiers: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers] = _root_.scala.None
  ): TPrimitiveTypeEntry =
    new Immutable(
      `type`,
      typeQualifiers
    )

  def unapply(_item: TPrimitiveTypeEntry): _root_.scala.Option[_root_.scala.Tuple2[org.apache.hive.service.rpc.thrift.TTypeId, Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers]]] = _root_.scala.Some(_item.toTuple)


  @inline private[thrift] def readTypeValue(_iprot: TProtocol): org.apache.hive.service.rpc.thrift.TTypeId = {
    org.apache.hive.service.rpc.thrift.TTypeId.getOrUnknown(_iprot.readI32())
  }

  @inline private def writeTypeField(type_item: org.apache.hive.service.rpc.thrift.TTypeId, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(TypeFieldI32)
    writeTypeValue(type_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeTypeValue(type_item: org.apache.hive.service.rpc.thrift.TTypeId, _oprot: TProtocol): Unit = {
    _oprot.writeI32(type_item.value)
  }

  @inline private[thrift] def readTypeQualifiersValue(_iprot: TProtocol): org.apache.hive.service.rpc.thrift.TTypeQualifiers = {
    org.apache.hive.service.rpc.thrift.TTypeQualifiers.decode(_iprot)
  }

  @inline private def writeTypeQualifiersField(typeQualifiers_item: org.apache.hive.service.rpc.thrift.TTypeQualifiers, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(TypeQualifiersField)
    writeTypeQualifiersValue(typeQualifiers_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeTypeQualifiersValue(typeQualifiers_item: org.apache.hive.service.rpc.thrift.TTypeQualifiers, _oprot: TProtocol): Unit = {
    typeQualifiers_item.write(_oprot)
  }


  object Immutable extends ThriftStructCodec3[TPrimitiveTypeEntry] {
    override def encode(_item: TPrimitiveTypeEntry, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): TPrimitiveTypeEntry = TPrimitiveTypeEntry.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[TPrimitiveTypeEntry] = TPrimitiveTypeEntry.metaData
  }

  /**
   * The default read-only implementation of TPrimitiveTypeEntry.  You typically should not need to
   * directly reference this class; instead, use the TPrimitiveTypeEntry.apply method to construct
   * new instances.
   */
  class Immutable(
      val `type`: org.apache.hive.service.rpc.thrift.TTypeId,
      val typeQualifiers: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TPrimitiveTypeEntry {
    def this(
      `type`: org.apache.hive.service.rpc.thrift.TTypeId,
      typeQualifiers: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers] = _root_.scala.None
    ) = this(
      `type`,
      typeQualifiers,
      immutable$Map.empty[Short, TFieldBlob]
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      val `type`: org.apache.hive.service.rpc.thrift.TTypeId,
      val typeQualifiers: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TPrimitiveTypeEntry {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }


    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode = super.hashCode
  }

  /**
   * This Proxy trait allows you to extend the TPrimitiveTypeEntry trait with additional state or
   * behavior and implement the read-only methods from TPrimitiveTypeEntry using an underlying
   * instance.
   */
  trait Proxy extends TPrimitiveTypeEntry {
    protected def _underlying_TPrimitiveTypeEntry: TPrimitiveTypeEntry
    override def `type`: org.apache.hive.service.rpc.thrift.TTypeId = _underlying_TPrimitiveTypeEntry.`type`
    override def typeQualifiers: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers] = _underlying_TPrimitiveTypeEntry.typeQualifiers
    override def _passthroughFields: immutable$Map[Short, TFieldBlob] = _underlying_TPrimitiveTypeEntry._passthroughFields
  }
}

/**
 * Prefer the companion object's [[org.apache.hive.service.rpc.thrift.TPrimitiveTypeEntry.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait TPrimitiveTypeEntry
  extends ThriftStruct
  with _root_.scala.Product2[org.apache.hive.service.rpc.thrift.TTypeId, Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers]]
  with ValidatingThriftStruct[TPrimitiveTypeEntry]
  with java.io.Serializable
{
  import TPrimitiveTypeEntry._

  def `type`: org.apache.hive.service.rpc.thrift.TTypeId
  def typeQualifiers: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1: org.apache.hive.service.rpc.thrift.TTypeId = `type`
  def _2: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers] = typeQualifiers

  def toTuple: _root_.scala.Tuple2[org.apache.hive.service.rpc.thrift.TTypeId, Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers]] = {
    (
      `type`,
      typeQualifiers
    )
  }


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (`type` ne null) {
                writeTypeValue(`type`, _oprot)
                _root_.scala.Some(TPrimitiveTypeEntry.TypeField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (typeQualifiers.isDefined) {
                writeTypeQualifiersValue(typeQualifiers.get, _oprot)
                _root_.scala.Some(TPrimitiveTypeEntry.TypeQualifiersField)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            _root_.scala.Some(TFieldBlob(_field, Buf.ByteArray.Owned(_buff.getArray())))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): TPrimitiveTypeEntry = {
    var `type`: org.apache.hive.service.rpc.thrift.TTypeId = this.`type`
    var typeQualifiers: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers] = this.typeQualifiers
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        `type` = readTypeValue(_blob.read)
      case 2 =>
        typeQualifiers = _root_.scala.Some(readTypeQualifiersValue(_blob.read))
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      `type`,
      typeQualifiers,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): TPrimitiveTypeEntry = {
    var `type`: org.apache.hive.service.rpc.thrift.TTypeId = this.`type`
    var typeQualifiers: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers] = this.typeQualifiers

    _fieldId match {
      case 1 =>
        `type` = null
      case 2 =>
        typeQualifiers = _root_.scala.None
      case _ =>
    }
    new Immutable(
      `type`,
      typeQualifiers,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetType: TPrimitiveTypeEntry = unsetField(1)

  def unsetTypeQualifiers: TPrimitiveTypeEntry = unsetField(2)


  override def write(_oprot: TProtocol): Unit = {
    TPrimitiveTypeEntry.validate(this)
    _oprot.writeStructBegin(Struct)
    if (`type` ne null) writeTypeField(`type`, _oprot)
    if (typeQualifiers.isDefined) writeTypeQualifiersField(typeQualifiers.get, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    `type`: org.apache.hive.service.rpc.thrift.TTypeId = this.`type`,
    typeQualifiers: _root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers] = this.typeQualifiers,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): TPrimitiveTypeEntry =
    new Immutable(
      `type`,
      typeQualifiers,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[TPrimitiveTypeEntry]

  private def _equals(x: TPrimitiveTypeEntry, y: TPrimitiveTypeEntry): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator) &&
      x._passthroughFields == y._passthroughFields

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[TPrimitiveTypeEntry])

  override def hashCode: Int = {
    _root_.scala.runtime.ScalaRunTime._hashCode(this)
  }

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 2

  override def productElement(n: Int): Any = n match {
    case 0 => this.`type`
    case 1 => this.typeQualifiers
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "TPrimitiveTypeEntry"

  def _codec: ValidatingThriftStructCodec3[TPrimitiveTypeEntry] = TPrimitiveTypeEntry

  def newBuilder(): StructBuilder[TPrimitiveTypeEntry] = new TPrimitiveTypeEntryStructBuilder(_root_.scala.Some(this), fieldTypes)
}

private[thrift] class TPrimitiveTypeEntryStructBuilder(instance: _root_.scala.Option[TPrimitiveTypeEntry], fieldTypes: IndexedSeq[ClassTag[_]])
    extends StructBuilder[TPrimitiveTypeEntry](fieldTypes) {

  def build(): TPrimitiveTypeEntry = instance match {
    case _root_.scala.Some(i) =>
      TPrimitiveTypeEntry(
        (if (fieldArray(0) == null) i.`type` else fieldArray(0)).asInstanceOf[org.apache.hive.service.rpc.thrift.TTypeId],
        (if (fieldArray(1) == null) i.typeQualifiers else fieldArray(1)).asInstanceOf[_root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers]]
      )
    case _root_.scala.None =>
      if (fieldArray.contains(null)) throw new InvalidFieldsException(structBuildError("TPrimitiveTypeEntry"))
      else {
        TPrimitiveTypeEntry(
          fieldArray(0).asInstanceOf[org.apache.hive.service.rpc.thrift.TTypeId],
          fieldArray(1).asInstanceOf[_root_.scala.Option[org.apache.hive.service.rpc.thrift.TTypeQualifiers]]
        )
      }
    }
}

