package generics;

import java.util.List;

public interface Repository<TYPE> {
    void deletar(TYPE objeto);
    TYPE inserir(TYPE obj);
    List<TYPE> listar();
}
