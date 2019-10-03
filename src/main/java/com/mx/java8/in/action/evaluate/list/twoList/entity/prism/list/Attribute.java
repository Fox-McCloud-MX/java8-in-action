package com.mx.java8.in.action.evaluate.list.twoList.entity.prism.list;

import com.mx.java8.in.action.evaluate.list.twoList.util.MapUtil;
import java.util.LinkedHashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {
    private String type;
    private String url;
    
    public Attribute(LinkedHashMap map) {
        this.type = MapUtil.getValue(map, "type");
        this.url = MapUtil.getValue(map, "url");
    }
}
