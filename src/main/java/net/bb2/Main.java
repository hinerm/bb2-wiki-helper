/*
 * #%L
 * Blood Brothers 2 Converters.
 * %%
 * Copyright (C) 2015 Blood Brothers 2 Wiki Members
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package net.bb2;

import javafx.stage.Stage;

import org.scijava.Context;

/**
 * Entry point to perform conversion.
 */
@SuppressWarnings("restriction")
public class Main {

	private static Stage stage;

	public static void setStage(final Stage stage) {
		Main.stage = stage;
	}

	public static void main(final String... args) throws Exception {
		final String id = args.length > 0 ? args[0] : "4219";
		final String outputDir = args.length > 1 ? args[1] : ".";
		final Context c = new Context();
		final JSONtoWikiService jws = c.service(JSONtoWikiService.class);
		try {
			jws.doConversion("http://www.bloodbrothers2.info/" + id + "/", outputDir);
		}
		finally {
			c.dispose();
			if (stage != null) stage.close();
		}
	}
}
