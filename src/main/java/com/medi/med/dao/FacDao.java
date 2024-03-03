package com.medi.med.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.medi.med.modelo.Factura;

public interface FacDao extends BaseDao<Factura, Integer>, JpaSpecificationExecutor<Factura> {

}
