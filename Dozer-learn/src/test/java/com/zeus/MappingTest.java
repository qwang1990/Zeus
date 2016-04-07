package com.zeus;

import com.zeus.domain.DestinationObject;
import com.zeus.object.SourceObject;
import com.zeus.object.SubItem;
import org.dozer.DozerBeanMapper;
import com.zeus.util.DozerHelper;
import org.junit.Before;
import org.junit.Test;


import java.util.*;

/**
 * Created by wangqi on 16/4/6.
 */
public class MappingTest {

    DozerBeanMapper mapper;
    SourceObject sourceObject;

    @Before
    public void prepareForMapping() {
        mapper = new DozerBeanMapper();

        /*
         *这里注释掉的话DestinationObject中的与SourceObject属性不同的元素就无法自动影视
         */
        List myMappingFiles = new ArrayList();
        myMappingFiles.add("mapMapping.xml");
        mapper.setMappingFiles(myMappingFiles);


        sourceObject = new SourceObject();
        sourceObject.setAge(1);
        sourceObject.setAlive(true);
        sourceObject.setUsername("wang");
        sourceObject.setPassword("qi");
        sourceObject.setBirthday(new Date());
        sourceObject.setSubItem(new SubItem("shanghai", Arrays.asList("wang","qi"),1));
        sourceObject.setSubItemList(Arrays.asList(new SubItem("shanghai1", Arrays.asList("wang1","qi1"),2),new SubItem("shanghai2", Arrays.asList("wang2","qi2"),3)));
    }

    //
    @Test
    public void testNormal() {
        System.out.println(sourceObject);
        DestinationObject destObject =
                mapper.map(sourceObject, DestinationObject.class);
        System.out.println(destObject);
    }

    @Test
    public void testMapVSObject() {
        Map<String,Object> myTestMapping = new HashMap<String,Object>();
        myTestMapping = mapper.map(sourceObject,Map.class);

        for(Map.Entry<String, Object> entry:myTestMapping.entrySet()){
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }

        SourceObject sourceObject1 = mapper.map(myTestMapping,SourceObject.class);
        System.out.println(sourceObject1);
    }

    /**
     * 因为配置,此处的map中对应sourceObject对象的alive的key值将变为map's alive
     */
    @Test
    public void testCustomMapKey() {
        Map<String,Object> myTestMapping = new HashMap<String,Object>();
        myTestMapping = mapper.map(sourceObject,Map.class,"1");
        for(Map.Entry<String, Object> entry:myTestMapping.entrySet()){
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }

    }

    @Test
    public void testCollection() {
        List<SourceObject> sourceObjects = new ArrayList<SourceObject>();
        sourceObjects.add(sourceObject);
        sourceObjects.add(sourceObject);

        //destinationObjects = new ArrayList<DestinationObject>();

        //mapper.map(sourceObjects,destinationObjects);
       // mapper.map();
        List<DestinationObject>  destinationObjects = DozerHelper.map(mapper,sourceObjects,DestinationObject.class);

        for (DestinationObject d : destinationObjects) {
            System.out.println(d);
        }
    }
}
