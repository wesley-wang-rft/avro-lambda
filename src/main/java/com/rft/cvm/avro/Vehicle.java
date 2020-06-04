/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.rft.cvm.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Vehicle extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6138035323072506624L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Vehicle\",\"namespace\":\"com.rft.cvm.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"ric\",\"type\":\"string\"},{\"name\":\"symbol\",\"type\":\"string\"},{\"name\":\"domain\",\"type\":\"string\"},{\"name\":\"exSourceCode\",\"type\":\"string\"},{\"name\":\"vehicleGroupId\",\"type\":\"int\"},{\"name\":\"displayName\",\"type\":\"string\"},{\"name\":\"isin\",\"type\":\"string\"},{\"name\":\"eligibleTe\",\"type\":\"int\"},{\"name\":\"eligibleSdi\",\"type\":\"int\"},{\"name\":\"vd\",\"type\":{\"type\":\"map\",\"values\":\"string\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Vehicle> ENCODER =
      new BinaryMessageEncoder<Vehicle>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Vehicle> DECODER =
      new BinaryMessageDecoder<Vehicle>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Vehicle> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Vehicle> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Vehicle>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Vehicle to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Vehicle from a ByteBuffer. */
  public static Vehicle fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long id;
  @Deprecated public java.lang.CharSequence ric;
  @Deprecated public java.lang.CharSequence symbol;
  @Deprecated public java.lang.CharSequence domain;
  @Deprecated public java.lang.CharSequence exSourceCode;
  @Deprecated public int vehicleGroupId;
  @Deprecated public java.lang.CharSequence displayName;
  @Deprecated public java.lang.CharSequence isin;
  @Deprecated public int eligibleTe;
  @Deprecated public int eligibleSdi;
  @Deprecated public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> vd;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Vehicle() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param ric The new value for ric
   * @param symbol The new value for symbol
   * @param domain The new value for domain
   * @param exSourceCode The new value for exSourceCode
   * @param vehicleGroupId The new value for vehicleGroupId
   * @param displayName The new value for displayName
   * @param isin The new value for isin
   * @param eligibleTe The new value for eligibleTe
   * @param eligibleSdi The new value for eligibleSdi
   * @param vd The new value for vd
   */
  public Vehicle(java.lang.Long id, java.lang.CharSequence ric, java.lang.CharSequence symbol, java.lang.CharSequence domain, java.lang.CharSequence exSourceCode, java.lang.Integer vehicleGroupId, java.lang.CharSequence displayName, java.lang.CharSequence isin, java.lang.Integer eligibleTe, java.lang.Integer eligibleSdi, java.util.Map<java.lang.CharSequence,java.lang.CharSequence> vd) {
    this.id = id;
    this.ric = ric;
    this.symbol = symbol;
    this.domain = domain;
    this.exSourceCode = exSourceCode;
    this.vehicleGroupId = vehicleGroupId;
    this.displayName = displayName;
    this.isin = isin;
    this.eligibleTe = eligibleTe;
    this.eligibleSdi = eligibleSdi;
    this.vd = vd;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return ric;
    case 2: return symbol;
    case 3: return domain;
    case 4: return exSourceCode;
    case 5: return vehicleGroupId;
    case 6: return displayName;
    case 7: return isin;
    case 8: return eligibleTe;
    case 9: return eligibleSdi;
    case 10: return vd;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: ric = (java.lang.CharSequence)value$; break;
    case 2: symbol = (java.lang.CharSequence)value$; break;
    case 3: domain = (java.lang.CharSequence)value$; break;
    case 4: exSourceCode = (java.lang.CharSequence)value$; break;
    case 5: vehicleGroupId = (java.lang.Integer)value$; break;
    case 6: displayName = (java.lang.CharSequence)value$; break;
    case 7: isin = (java.lang.CharSequence)value$; break;
    case 8: eligibleTe = (java.lang.Integer)value$; break;
    case 9: eligibleSdi = (java.lang.Integer)value$; break;
    case 10: vd = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'ric' field.
   * @return The value of the 'ric' field.
   */
  public java.lang.CharSequence getRic() {
    return ric;
  }

  /**
   * Sets the value of the 'ric' field.
   * @param value the value to set.
   */
  public void setRic(java.lang.CharSequence value) {
    this.ric = value;
  }

  /**
   * Gets the value of the 'symbol' field.
   * @return The value of the 'symbol' field.
   */
  public java.lang.CharSequence getSymbol() {
    return symbol;
  }

  /**
   * Sets the value of the 'symbol' field.
   * @param value the value to set.
   */
  public void setSymbol(java.lang.CharSequence value) {
    this.symbol = value;
  }

  /**
   * Gets the value of the 'domain' field.
   * @return The value of the 'domain' field.
   */
  public java.lang.CharSequence getDomain() {
    return domain;
  }

  /**
   * Sets the value of the 'domain' field.
   * @param value the value to set.
   */
  public void setDomain(java.lang.CharSequence value) {
    this.domain = value;
  }

  /**
   * Gets the value of the 'exSourceCode' field.
   * @return The value of the 'exSourceCode' field.
   */
  public java.lang.CharSequence getExSourceCode() {
    return exSourceCode;
  }

  /**
   * Sets the value of the 'exSourceCode' field.
   * @param value the value to set.
   */
  public void setExSourceCode(java.lang.CharSequence value) {
    this.exSourceCode = value;
  }

  /**
   * Gets the value of the 'vehicleGroupId' field.
   * @return The value of the 'vehicleGroupId' field.
   */
  public java.lang.Integer getVehicleGroupId() {
    return vehicleGroupId;
  }

  /**
   * Sets the value of the 'vehicleGroupId' field.
   * @param value the value to set.
   */
  public void setVehicleGroupId(java.lang.Integer value) {
    this.vehicleGroupId = value;
  }

  /**
   * Gets the value of the 'displayName' field.
   * @return The value of the 'displayName' field.
   */
  public java.lang.CharSequence getDisplayName() {
    return displayName;
  }

  /**
   * Sets the value of the 'displayName' field.
   * @param value the value to set.
   */
  public void setDisplayName(java.lang.CharSequence value) {
    this.displayName = value;
  }

  /**
   * Gets the value of the 'isin' field.
   * @return The value of the 'isin' field.
   */
  public java.lang.CharSequence getIsin() {
    return isin;
  }

  /**
   * Sets the value of the 'isin' field.
   * @param value the value to set.
   */
  public void setIsin(java.lang.CharSequence value) {
    this.isin = value;
  }

  /**
   * Gets the value of the 'eligibleTe' field.
   * @return The value of the 'eligibleTe' field.
   */
  public java.lang.Integer getEligibleTe() {
    return eligibleTe;
  }

  /**
   * Sets the value of the 'eligibleTe' field.
   * @param value the value to set.
   */
  public void setEligibleTe(java.lang.Integer value) {
    this.eligibleTe = value;
  }

  /**
   * Gets the value of the 'eligibleSdi' field.
   * @return The value of the 'eligibleSdi' field.
   */
  public java.lang.Integer getEligibleSdi() {
    return eligibleSdi;
  }

  /**
   * Sets the value of the 'eligibleSdi' field.
   * @param value the value to set.
   */
  public void setEligibleSdi(java.lang.Integer value) {
    this.eligibleSdi = value;
  }

  /**
   * Gets the value of the 'vd' field.
   * @return The value of the 'vd' field.
   */
  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getVd() {
    return vd;
  }

  /**
   * Sets the value of the 'vd' field.
   * @param value the value to set.
   */
  public void setVd(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
    this.vd = value;
  }

  /**
   * Creates a new Vehicle RecordBuilder.
   * @return A new Vehicle RecordBuilder
   */
  public static com.rft.cvm.avro.Vehicle.Builder newBuilder() {
    return new com.rft.cvm.avro.Vehicle.Builder();
  }

  /**
   * Creates a new Vehicle RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Vehicle RecordBuilder
   */
  public static com.rft.cvm.avro.Vehicle.Builder newBuilder(com.rft.cvm.avro.Vehicle.Builder other) {
    return new com.rft.cvm.avro.Vehicle.Builder(other);
  }

  /**
   * Creates a new Vehicle RecordBuilder by copying an existing Vehicle instance.
   * @param other The existing instance to copy.
   * @return A new Vehicle RecordBuilder
   */
  public static com.rft.cvm.avro.Vehicle.Builder newBuilder(com.rft.cvm.avro.Vehicle other) {
    return new com.rft.cvm.avro.Vehicle.Builder(other);
  }

  /**
   * RecordBuilder for Vehicle instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Vehicle>
    implements org.apache.avro.data.RecordBuilder<Vehicle> {

    private long id;
    private java.lang.CharSequence ric;
    private java.lang.CharSequence symbol;
    private java.lang.CharSequence domain;
    private java.lang.CharSequence exSourceCode;
    private int vehicleGroupId;
    private java.lang.CharSequence displayName;
    private java.lang.CharSequence isin;
    private int eligibleTe;
    private int eligibleSdi;
    private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> vd;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.rft.cvm.avro.Vehicle.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.ric)) {
        this.ric = data().deepCopy(fields()[1].schema(), other.ric);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.symbol)) {
        this.symbol = data().deepCopy(fields()[2].schema(), other.symbol);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.domain)) {
        this.domain = data().deepCopy(fields()[3].schema(), other.domain);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.exSourceCode)) {
        this.exSourceCode = data().deepCopy(fields()[4].schema(), other.exSourceCode);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.vehicleGroupId)) {
        this.vehicleGroupId = data().deepCopy(fields()[5].schema(), other.vehicleGroupId);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.displayName)) {
        this.displayName = data().deepCopy(fields()[6].schema(), other.displayName);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.isin)) {
        this.isin = data().deepCopy(fields()[7].schema(), other.isin);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.eligibleTe)) {
        this.eligibleTe = data().deepCopy(fields()[8].schema(), other.eligibleTe);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.eligibleSdi)) {
        this.eligibleSdi = data().deepCopy(fields()[9].schema(), other.eligibleSdi);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.vd)) {
        this.vd = data().deepCopy(fields()[10].schema(), other.vd);
        fieldSetFlags()[10] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Vehicle instance
     * @param other The existing instance to copy.
     */
    private Builder(com.rft.cvm.avro.Vehicle other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.ric)) {
        this.ric = data().deepCopy(fields()[1].schema(), other.ric);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.symbol)) {
        this.symbol = data().deepCopy(fields()[2].schema(), other.symbol);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.domain)) {
        this.domain = data().deepCopy(fields()[3].schema(), other.domain);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.exSourceCode)) {
        this.exSourceCode = data().deepCopy(fields()[4].schema(), other.exSourceCode);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.vehicleGroupId)) {
        this.vehicleGroupId = data().deepCopy(fields()[5].schema(), other.vehicleGroupId);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.displayName)) {
        this.displayName = data().deepCopy(fields()[6].schema(), other.displayName);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.isin)) {
        this.isin = data().deepCopy(fields()[7].schema(), other.isin);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.eligibleTe)) {
        this.eligibleTe = data().deepCopy(fields()[8].schema(), other.eligibleTe);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.eligibleSdi)) {
        this.eligibleSdi = data().deepCopy(fields()[9].schema(), other.eligibleSdi);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.vd)) {
        this.vd = data().deepCopy(fields()[10].schema(), other.vd);
        fieldSetFlags()[10] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.Long getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'ric' field.
      * @return The value.
      */
    public java.lang.CharSequence getRic() {
      return ric;
    }

    /**
      * Sets the value of the 'ric' field.
      * @param value The value of 'ric'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setRic(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.ric = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'ric' field has been set.
      * @return True if the 'ric' field has been set, false otherwise.
      */
    public boolean hasRic() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'ric' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearRic() {
      ric = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'symbol' field.
      * @return The value.
      */
    public java.lang.CharSequence getSymbol() {
      return symbol;
    }

    /**
      * Sets the value of the 'symbol' field.
      * @param value The value of 'symbol'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setSymbol(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.symbol = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'symbol' field has been set.
      * @return True if the 'symbol' field has been set, false otherwise.
      */
    public boolean hasSymbol() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'symbol' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearSymbol() {
      symbol = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'domain' field.
      * @return The value.
      */
    public java.lang.CharSequence getDomain() {
      return domain;
    }

    /**
      * Sets the value of the 'domain' field.
      * @param value The value of 'domain'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setDomain(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.domain = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'domain' field has been set.
      * @return True if the 'domain' field has been set, false otherwise.
      */
    public boolean hasDomain() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'domain' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearDomain() {
      domain = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'exSourceCode' field.
      * @return The value.
      */
    public java.lang.CharSequence getExSourceCode() {
      return exSourceCode;
    }

    /**
      * Sets the value of the 'exSourceCode' field.
      * @param value The value of 'exSourceCode'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setExSourceCode(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.exSourceCode = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'exSourceCode' field has been set.
      * @return True if the 'exSourceCode' field has been set, false otherwise.
      */
    public boolean hasExSourceCode() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'exSourceCode' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearExSourceCode() {
      exSourceCode = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'vehicleGroupId' field.
      * @return The value.
      */
    public java.lang.Integer getVehicleGroupId() {
      return vehicleGroupId;
    }

    /**
      * Sets the value of the 'vehicleGroupId' field.
      * @param value The value of 'vehicleGroupId'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setVehicleGroupId(int value) {
      validate(fields()[5], value);
      this.vehicleGroupId = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'vehicleGroupId' field has been set.
      * @return True if the 'vehicleGroupId' field has been set, false otherwise.
      */
    public boolean hasVehicleGroupId() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'vehicleGroupId' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearVehicleGroupId() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'displayName' field.
      * @return The value.
      */
    public java.lang.CharSequence getDisplayName() {
      return displayName;
    }

    /**
      * Sets the value of the 'displayName' field.
      * @param value The value of 'displayName'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setDisplayName(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.displayName = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'displayName' field has been set.
      * @return True if the 'displayName' field has been set, false otherwise.
      */
    public boolean hasDisplayName() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'displayName' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearDisplayName() {
      displayName = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'isin' field.
      * @return The value.
      */
    public java.lang.CharSequence getIsin() {
      return isin;
    }

    /**
      * Sets the value of the 'isin' field.
      * @param value The value of 'isin'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setIsin(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.isin = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'isin' field has been set.
      * @return True if the 'isin' field has been set, false otherwise.
      */
    public boolean hasIsin() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'isin' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearIsin() {
      isin = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'eligibleTe' field.
      * @return The value.
      */
    public java.lang.Integer getEligibleTe() {
      return eligibleTe;
    }

    /**
      * Sets the value of the 'eligibleTe' field.
      * @param value The value of 'eligibleTe'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setEligibleTe(int value) {
      validate(fields()[8], value);
      this.eligibleTe = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'eligibleTe' field has been set.
      * @return True if the 'eligibleTe' field has been set, false otherwise.
      */
    public boolean hasEligibleTe() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'eligibleTe' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearEligibleTe() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'eligibleSdi' field.
      * @return The value.
      */
    public java.lang.Integer getEligibleSdi() {
      return eligibleSdi;
    }

    /**
      * Sets the value of the 'eligibleSdi' field.
      * @param value The value of 'eligibleSdi'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setEligibleSdi(int value) {
      validate(fields()[9], value);
      this.eligibleSdi = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'eligibleSdi' field has been set.
      * @return True if the 'eligibleSdi' field has been set, false otherwise.
      */
    public boolean hasEligibleSdi() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'eligibleSdi' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearEligibleSdi() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'vd' field.
      * @return The value.
      */
    public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getVd() {
      return vd;
    }

    /**
      * Sets the value of the 'vd' field.
      * @param value The value of 'vd'.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder setVd(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
      validate(fields()[10], value);
      this.vd = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'vd' field has been set.
      * @return True if the 'vd' field has been set, false otherwise.
      */
    public boolean hasVd() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'vd' field.
      * @return This builder.
      */
    public com.rft.cvm.avro.Vehicle.Builder clearVd() {
      vd = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Vehicle build() {
      try {
        Vehicle record = new Vehicle();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.ric = fieldSetFlags()[1] ? this.ric : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.symbol = fieldSetFlags()[2] ? this.symbol : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.domain = fieldSetFlags()[3] ? this.domain : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.exSourceCode = fieldSetFlags()[4] ? this.exSourceCode : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.vehicleGroupId = fieldSetFlags()[5] ? this.vehicleGroupId : (java.lang.Integer) defaultValue(fields()[5]);
        record.displayName = fieldSetFlags()[6] ? this.displayName : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.isin = fieldSetFlags()[7] ? this.isin : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.eligibleTe = fieldSetFlags()[8] ? this.eligibleTe : (java.lang.Integer) defaultValue(fields()[8]);
        record.eligibleSdi = fieldSetFlags()[9] ? this.eligibleSdi : (java.lang.Integer) defaultValue(fields()[9]);
        record.vd = fieldSetFlags()[10] ? this.vd : (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) defaultValue(fields()[10]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Vehicle>
    WRITER$ = (org.apache.avro.io.DatumWriter<Vehicle>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Vehicle>
    READER$ = (org.apache.avro.io.DatumReader<Vehicle>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
