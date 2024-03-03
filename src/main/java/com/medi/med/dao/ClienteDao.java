package com.medi.med.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.medi.med.modelo.Cliente;

public interface ClienteDao extends BaseDao<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {

}
