package stream.mokulive.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.mapper.TypeMapper;
import stream.mokulive.storage.service.ITypeService;
import stream.mokulive.storage.utils.IdGenerator;
import stream.mokulive.storage.vo.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public void addType(Type type) throws Exception {
        Map params = new HashMap();
        params.put("typeName",type.getTypeName());
        int count = typeMapper.checkName(params);
        if(count == 0) {
            type.setTypeId(IdGenerator.generate());
            typeMapper.addType(type);
        }else{
            throw new DuplicateNameException();
        }
    }

    @Override
    public void updateType(Type type) throws Exception {
        typeMapper.updateType(type);
    }

    @Override
    public void deleteType(String typeId) throws Exception{
        Map params = new HashMap();
        params.put("typeId",typeId);
        typeMapper.deleteType(params);
    }

    @Override
    public Type findTypeById(String typeId) throws Exception {
        Type type = null;
        Map params = new HashMap();
        params.put("typeId",typeId);
        List<Type> list = new ArrayList();
        list = typeMapper.findTypeList(params);
        if(list.size()>0){
            type = list.get(0);
        }
        return type;
    }

    @Override
    public List<Type> findTypeList() throws Exception {
        Map params = new HashMap();
        return typeMapper.findTypeList(params);
    }

}
