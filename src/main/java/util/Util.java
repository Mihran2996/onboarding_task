package util;

import org.jooq.Field;
import org.jooq.impl.DSL;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.jooq.impl.DSL.name;

public class Util {
    public Field<Object> getField(String column) {
        return DSL.field(name(column));
    }

    public List<Field<Object>> getFields(Collection<String> columns) {
        return columns.stream()
                .map(this::getField)
                .collect(Collectors.toList());
    }
}
