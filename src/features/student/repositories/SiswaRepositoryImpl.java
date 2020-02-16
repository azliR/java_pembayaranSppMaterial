/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.student.repositories;

import features.student.entities.Siswa;
import features.student.entities.SiswaJpaController;
import java.util.List;

/**
 *
 * @author rizal
 */
public class SiswaRepositoryImpl extends SiswaRepository {

    final SiswaJpaController siswaJpaController;

    public SiswaRepositoryImpl(SiswaJpaController siswaJpaController) {
        this.siswaJpaController = siswaJpaController;
    }

    @Override
    public List<Siswa> getListSiswaWithoutThumbnail(int maxResults, int firstResult) {
        return siswaJpaController.findSiswaEntities(maxResults, firstResult);
    }

    @Override
    public byte[] getSiswaThumbnail(int id) {
        return null;
    }
}
