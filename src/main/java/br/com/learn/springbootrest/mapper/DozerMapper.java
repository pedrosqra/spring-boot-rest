package br.com.learn.springbootrest.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    private static final Mapper mapper = new DozerBeanMapper();

    public static <O, D> D parseObject(O origin, Class<D> destinationClass) {
        return mapper.map(origin, destinationClass);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destinationClass) {
        List<D> destinationObjects = new ArrayList<>();
        for (O originObject : origin) {
            destinationObjects.add(parseObject(originObject, destinationClass));
        }
        return destinationObjects;
    }
}
