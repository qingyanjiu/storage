package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.Type;

import java.util.List;

public interface ITypeService {

    void addType(Type type) throws Exception;

    void updateType(Type type) throws Exception;

    void deleteType(String typeId) throws Exception;

    Type findTypeById(String typeId) throws Exception;

    List<Type> findTypeList() throws Exception;
}
