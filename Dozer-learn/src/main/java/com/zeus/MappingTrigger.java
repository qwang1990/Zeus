package com.zeus;

import com.zeus.domain.DestinationObject;
import com.zeus.object.SourceObject;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by wangqi on 16/4/6.
 */
public class MappingTrigger {

    public static void main(String[] args) {
        SourceObject sourceObject = new SourceObject();
        sourceObject.setAge(1);
        sourceObject.setAlive(true);
        sourceObject.setUsername("wang");
        sourceObject.setPassword("qi");
        Mapper mapper = new DozerBeanMapper();
        DestinationObject destObject =
                mapper.map(sourceObject, DestinationObject.class);

        System.out.println(destObject);
    }
}
