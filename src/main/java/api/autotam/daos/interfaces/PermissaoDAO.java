package api.autotam.daos.interfaces;

import api.autotam.model.Permissao;

import java.util.List;

/**
 * Interface responsável por encapsular as assinaturas dos métodos das operações referentes aos registros no banco de
 * dados da classe Permissão.
 *
 * @author Danilo
 */

public interface PermissaoDAO {

    void savePermissao(Permissao permissao);

    Permissao findById(int idPermissao);

    void updatePermissao(Permissao permissao);

    void deletePermissao(int idPermissao);

    boolean usuarioHasPermissaoToAnalise(int idAnalise, int idUsuario);

    boolean usuarioIsAdministrador(int idAnalise, int idUsuario);

    boolean usuarioIsTestador(int idAnalise, int idUsuario);

    List<Permissao> findAllPermissoesFromUsuario(int idUsuario);

    List<Permissao> findAllPermissoesFromAnalise (int idAnalise);
}
