/*
 * ====================================================================
 * Project:     openCRX/Sample, http://www.opencrx.org/
 * Description: SegmentImpl
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
package org.opencrx.sample.client1.aop2;

import org.opencrx.sample.backend.Sample;
import org.opencrx.sample.client1.jmi1.QueryAccountResult;
import org.openmdx.base.accessor.jmi.cci.JmiServiceException;
import org.openmdx.base.aop2.AbstractObject;

/**
 * SegmentImpl
 *
 * @param <S>
 * @param <N>
 * @param <C>
 */
public class SegmentImpl<S extends org.opencrx.sample.client1.jmi1.Segment, N extends org.opencrx.sample.client1.cci2.Segment, C extends Void>
    extends AbstractObject<S, N, C> {

	/**
	 * Constructor.
	 * 
	 * @param same
	 * @param next
	 */
	public SegmentImpl(
		S same,
		N next
	) {
		super(
			same,
			next
		);
	}

	/**
	 * queryAccounts implementation.
	 * 
	 * @param params
	 * @return
	 */
	public org.opencrx.sample.client1.jmi1.QueryAccountResult queryAccounts(
		org.opencrx.sample.client1.jmi1.QueryAccountParams params
	) {
		try {
			String queryFullName = params.getName();
			String queryCity = params.getPostalCity();
			QueryAccountResult result = Sample.getInstance().queryAccounts(
				queryFullName,
				queryCity,
				this.sameObject()
			);
			return result;
		} catch (Exception e) {
			throw new JmiServiceException(e);
		}
	}
	
}
