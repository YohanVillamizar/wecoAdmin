/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.facade;

import com.weco.nanotech.admin.entity.ActivityLog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YohanVillamizar
 */
@Stateless
public class ActivityLogFacade extends AbstractFacade<ActivityLog> {

    @PersistenceContext(unitName = "WecoAdminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivityLogFacade() {
        super(ActivityLog.class);
    }
    
}
