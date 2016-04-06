package com.zeus;

import com.zeus.domain.DestinationObject;
import com.zeus.object.SourceObject;
import com.zeus.object.SubItem;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.metadata.ClassMappingMetadata;
import org.dozer.metadata.MappingMetadata;

import java.util.*;

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
        sourceObject.setBirthday(new Date());
        sourceObject.setSubItem(new SubItem("shanghai", Arrays.asList("wang","qi")));
        /**
         * For real-world applications it is NOT recommended to create a new instance of the Mapper each time you map objects.
         * Typically a system will only have one DozerBeanMapper instance per VM
         * The DozerBeanMapper.java class is thread safe.
         */
        DozerBeanMapper mapper = new DozerBeanMapper();
        List myMappingFiles = new ArrayList();
        myMappingFiles.add("mapMapping.xml");
        mapper.setMappingFiles(myMappingFiles);

        MappingMetadata mappingMetadata =  mapper.getMappingMetadata();

        ClassMappingMetadata classMappingMetadata =
                mappingMetadata.getClassMapping(SourceObject.class, Map.class);


        DestinationObject destObject =
                mapper.map(sourceObject, DestinationObject.class);

        System.out.println(classMappingMetadata);

        Map<String,Object> myTestMapping = new HashMap<String,Object>();
        /*myTestMapping.put("username",null);
        myTestMapping.put("password",null);
        myTestMapping.put("age",null);
        myTestMapping.put("alive",null);
        */

        myTestMapping = mapper.map(sourceObject,Map.class,"myTestMapping");

        for(Map.Entry<String, Object> entry:myTestMapping.entrySet()){
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }


     //   System.out.println(destObject);
    }
}
