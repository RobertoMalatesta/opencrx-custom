/*
 * ====================================================================
 * Project:     openCRX/Sample, http://www.opencrx.org/
 * Description: GadgetImpl
 * Owner:       the original authors.
 * ====================================================================
 *
 * This software is published under the BSD license
 * as listed below.
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions 
 * are met:
 * 
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in
 * the documentation and/or other materials provided with the
 * distribution.
 * 
 * * Neither the name of the openCRX team nor the names of the contributors
 * to openCRX may be used to endorse or promote products derived
 * from this software without specific prior written permission
 * 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * ------------------
 * 
 * This product includes software developed by the Apache Software
 * Foundation (http://www.apache.org/).
 * 
 * This product includes software developed by contributors to
 * openMDX (http://www.openmdx.org/)
 */
package org.opencrx.sample.account1.aop2;

import javax.jdo.listener.StoreCallback;

import org.openmdx.base.accessor.jmi.cci.JmiServiceException;
import org.openmdx.base.aop2.AbstractObject;

import org.opencrx.sample.backend.Sample;

/**
 * GadgetImpl
 *
 */
public class GadgetImpl
	<S extends org.opencrx.sample.account1.jmi1.Gadget,N extends org.opencrx.sample.account1.cci2.Gadget,C extends Void>
	extends AbstractObject<S,N,C>
	implements StoreCallback {

    /**
     * Constructor.
     * 
     * @param same
     * @param next
     */
    public GadgetImpl(
        S same,
        N next
    ) {
    	super(same, next);
    }
    
    /**
     * Implementation of sendGadgetInfo operation.
     * 
     * @param in
     * @return
     */
    public org.openmdx.base.jmi1.Void sendGadgetInfo(
        org.opencrx.sample.account1.jmi1.SendGadgetInfoParams in
    ) {
    	try {
    		Sample.getInstance().sendGadgetInfo(
    			this.sameObject(), 
    			in.getToUsers()
    		);
    		return super.newVoid();
    	} catch(Exception e) {
    		throw new JmiServiceException(e);
    	}
    }
    
	/* (non-Javadoc)
	 * @see org.openmdx.base.aop2.AbstractObject#jdoPreStore()
	 */
	@Override
    public void jdoPreStore(
    ) {
		super.jdoPreStore();
	}
	
}
