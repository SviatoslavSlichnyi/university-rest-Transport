package university.lab.transport.entity.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MeasurementType {
    KM("KM", "kilometer"),
    M("M", "meters");

    private final String shortCode;
    private final String fullName;
}
