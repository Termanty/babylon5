/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtumini.domain;

import javax.persistence.Column;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author jelmnain
 */
public abstract class Reference extends AbstractPersistable<Long> {
    @Column
    protected String name;
    @Column
    protected String author;
    
}
