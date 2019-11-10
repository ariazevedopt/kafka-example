/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.kafka.schema;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class UserExample extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2684619762582496950L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserExample\",\"namespace\":\"com.kafka.schema\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"\"},{\"name\":\"gender\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"\"},{\"name\":\"age\",\"type\":\"int\",\"default\":\"\"},{\"name\":\"group\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<UserExample> ENCODER =
      new BinaryMessageEncoder<UserExample>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<UserExample> DECODER =
      new BinaryMessageDecoder<UserExample>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<UserExample> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<UserExample> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<UserExample>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this UserExample to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a UserExample from a ByteBuffer. */
  public static UserExample fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String name;
  @Deprecated public java.lang.String gender;
  @Deprecated public int age;
  @Deprecated public java.lang.String group;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UserExample() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param gender The new value for gender
   * @param age The new value for age
   * @param group The new value for group
   */
  public UserExample(java.lang.String name, java.lang.String gender, java.lang.Integer age, java.lang.String group) {
    this.name = name;
    this.gender = gender;
    this.age = age;
    this.group = group;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return gender;
    case 2: return age;
    case 3: return group;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.String)value$; break;
    case 1: gender = (java.lang.String)value$; break;
    case 2: age = (java.lang.Integer)value$; break;
    case 3: group = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'gender' field.
   * @return The value of the 'gender' field.
   */
  public java.lang.String getGender() {
    return gender;
  }

  /**
   * Sets the value of the 'gender' field.
   * @param value the value to set.
   */
  public void setGender(java.lang.String value) {
    this.gender = value;
  }

  /**
   * Gets the value of the 'age' field.
   * @return The value of the 'age' field.
   */
  public java.lang.Integer getAge() {
    return age;
  }

  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(java.lang.Integer value) {
    this.age = value;
  }

  /**
   * Gets the value of the 'group' field.
   * @return The value of the 'group' field.
   */
  public java.lang.String getGroup() {
    return group;
  }

  /**
   * Sets the value of the 'group' field.
   * @param value the value to set.
   */
  public void setGroup(java.lang.String value) {
    this.group = value;
  }

  /**
   * Creates a new UserExample RecordBuilder.
   * @return A new UserExample RecordBuilder
   */
  public static com.kafka.schema.UserExample.Builder newBuilder() {
    return new com.kafka.schema.UserExample.Builder();
  }

  /**
   * Creates a new UserExample RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UserExample RecordBuilder
   */
  public static com.kafka.schema.UserExample.Builder newBuilder(com.kafka.schema.UserExample.Builder other) {
    return new com.kafka.schema.UserExample.Builder(other);
  }

  /**
   * Creates a new UserExample RecordBuilder by copying an existing UserExample instance.
   * @param other The existing instance to copy.
   * @return A new UserExample RecordBuilder
   */
  public static com.kafka.schema.UserExample.Builder newBuilder(com.kafka.schema.UserExample other) {
    return new com.kafka.schema.UserExample.Builder(other);
  }

  /**
   * RecordBuilder for UserExample instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserExample>
    implements org.apache.avro.data.RecordBuilder<UserExample> {

    private java.lang.String name;
    private java.lang.String gender;
    private int age;
    private java.lang.String group;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafka.schema.UserExample.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.gender)) {
        this.gender = data().deepCopy(fields()[1].schema(), other.gender);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.group)) {
        this.group = data().deepCopy(fields()[3].schema(), other.group);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing UserExample instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafka.schema.UserExample other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.gender)) {
        this.gender = data().deepCopy(fields()[1].schema(), other.gender);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.group)) {
        this.group = data().deepCopy(fields()[3].schema(), other.group);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.kafka.schema.UserExample.Builder setName(java.lang.String value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.kafka.schema.UserExample.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'gender' field.
      * @return The value.
      */
    public java.lang.String getGender() {
      return gender;
    }

    /**
      * Sets the value of the 'gender' field.
      * @param value The value of 'gender'.
      * @return This builder.
      */
    public com.kafka.schema.UserExample.Builder setGender(java.lang.String value) {
      validate(fields()[1], value);
      this.gender = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'gender' field has been set.
      * @return True if the 'gender' field has been set, false otherwise.
      */
    public boolean hasGender() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'gender' field.
      * @return This builder.
      */
    public com.kafka.schema.UserExample.Builder clearGender() {
      gender = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'age' field.
      * @return The value.
      */
    public java.lang.Integer getAge() {
      return age;
    }

    /**
      * Sets the value of the 'age' field.
      * @param value The value of 'age'.
      * @return This builder.
      */
    public com.kafka.schema.UserExample.Builder setAge(int value) {
      validate(fields()[2], value);
      this.age = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'age' field has been set.
      * @return True if the 'age' field has been set, false otherwise.
      */
    public boolean hasAge() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'age' field.
      * @return This builder.
      */
    public com.kafka.schema.UserExample.Builder clearAge() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'group' field.
      * @return The value.
      */
    public java.lang.String getGroup() {
      return group;
    }

    /**
      * Sets the value of the 'group' field.
      * @param value The value of 'group'.
      * @return This builder.
      */
    public com.kafka.schema.UserExample.Builder setGroup(java.lang.String value) {
      validate(fields()[3], value);
      this.group = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'group' field has been set.
      * @return True if the 'group' field has been set, false otherwise.
      */
    public boolean hasGroup() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'group' field.
      * @return This builder.
      */
    public com.kafka.schema.UserExample.Builder clearGroup() {
      group = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserExample build() {
      try {
        UserExample record = new UserExample();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.String) defaultValue(fields()[0]);
        record.gender = fieldSetFlags()[1] ? this.gender : (java.lang.String) defaultValue(fields()[1]);
        record.age = fieldSetFlags()[2] ? this.age : (java.lang.Integer) defaultValue(fields()[2]);
        record.group = fieldSetFlags()[3] ? this.group : (java.lang.String) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<UserExample>
    WRITER$ = (org.apache.avro.io.DatumWriter<UserExample>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<UserExample>
    READER$ = (org.apache.avro.io.DatumReader<UserExample>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
