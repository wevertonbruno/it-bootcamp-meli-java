package repositories;

import exceptions.EntityNotFoundException;

import java.util.List;

public interface CRUDRepository<DataType, IdType> {
    public DataType create(DataType entity);
    public void update(IdType ID, DataType entity);
    public void delete(IdType ID);
    public List<DataType> listAll();
    public DataType get(IdType id) throws EntityNotFoundException;
}
