package eu.arrowhead.gams.api.model;

import io.swagger.v3.oas.annotations.Parameter;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class SensorData {

    @Parameter(description = "The id of the source sensor.", required = false)
    private String sensorId;

    @Parameter(description = "The timestamp of event generation with timezone. Defaults to \"now\" in UTC.",
        required = false)
    private ZonedDateTime timestamp = ZonedDateTime.now(ZoneOffset.UTC);

    @Parameter(description = "The value which was read by the sensor.", required = true)
    private Long value;

    @Parameter(description = "The magnitude of the data. "
        + "Example: A value of 32700 with a magnitude of 1000 indicates that the actual value was 32.7", required =
        false)
    private Long magnitude = 1L;

    @Parameter(description = "The unit in which the value was given", required = false)
    private String unit;

    public SensorData() {
        super();
    }

    public SensorData(Long value) {
        this.value = value;
    }

    public SensorData(String sensorId, ZonedDateTime timestamp, Long value, Long magnitude, String unit) {
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.value = value;
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Long magnitude) {
        this.magnitude = magnitude;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SensorData that = (SensorData) o;
        return Objects.equals(sensorId, that.sensorId) && timestamp.equals(that.timestamp) && value.equals(that.value)
            && magnitude.equals(that.magnitude) && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorId, timestamp, value, magnitude, unit);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SensorData.class.getSimpleName() + "[", "]").add("sensorId='" + sensorId + "'")
                                                                                  .add("timestamp=" + timestamp)
                                                                                  .add("value=" + value)
                                                                                  .add("magnitude=" + magnitude)
                                                                                  .add("unit='" + unit + "'")
                                                                                  .toString();
    }
}
