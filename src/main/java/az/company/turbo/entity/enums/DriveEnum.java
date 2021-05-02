package az.company.turbo.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;


public enum DriveEnum {
    front_wheel("front"),
    rear_wheel("rear"),
    all_wheel("all");

    DriveEnum(String front) {
    }
}
