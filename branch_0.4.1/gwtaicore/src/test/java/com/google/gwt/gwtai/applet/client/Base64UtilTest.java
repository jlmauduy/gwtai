package com.google.gwt.gwtai.applet.client;

import com.google.gwt.user.server.Base64Utils;
import java.io.UnsupportedEncodingException;
import org.apache.catalina.util.Base64;

import junit.framework.TestCase;

/**
 * Test class for <code>com.google.gwt.gwtai.applet.client.Base64Util</code>.
 * 
 * @author Adrian Buerki <a.buerki@gmail.com>
 */
public class Base64UtilTest extends TestCase {
    public static String TEST_INPUT = "abcdefg \u00d8\u00c8 \u00f8\u00c5";
    public static String TEST_OUTPUT = "YWJjZGVmZyDDmMOIIMO4w4U=";
    public static String TEST_LONG_STRING = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "<!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.0//EN' 'http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd'>"
            + "<svg height=\"841\" style=\"color-interpolation:auto; color-rendering:auto; fill:black; fill-opacity:1; font-family:&apos;Dialog&apos;; font-size:12; font-style:normal; font-weight:normal; image-rendering:auto; shape-rendering:auto; stroke:black; stroke-dasharray:none; stroke-dashoffset:0; stroke-linecap:square; stroke-linejoin:miter; stroke-miterlimit:10; stroke-opacity:1; stroke-width:1; text-rendering:auto;\" width=\"595\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">"
            + "  <!--Generated by the Batik Graphics2D SVG Generator-->"
            + "  <defs id=\"genericDefs\" />"
            + "  <g>"
            + "    <defs id=\"defs1\">"
            + "      <clipPath clipPathUnits=\"userSpaceOnUse\" id=\"clipPath1\">"
            + "        <path d=\"M0 0 L523 0 L523 769 L0 769 L0 0 Z\" />"
            + "      </clipPath>"
            + "    </defs>"
            + "    <g style=\"fill:rgb(111,111,111); font-family:sans-serif; font-size:24; shape-rendering:optimizeSpeed; stroke:rgb(111,111,111); text-rendering:geometricPrecision;\" transform=\"translate(36,36)\">"
            + "      <text style=\"clip-path:url(#clipPath1); stroke:none;\" x=\"389\" xml:space=\"preserve\" y=\"47\">Apaq Shop</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-size:20; stroke:none;\" x=\"9\" xml:space=\"preserve\" y=\"148\">Faktura</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-size:10; stroke:none;\" x=\"440\" xml:space=\"preserve\" y=\"140\">Fakturanr.: 727</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-size:10; stroke:none;\" x=\"449\" xml:space=\"preserve\" y=\"155\">Ordrenr.: 727</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-size:10; stroke:none;\" x=\"403\" xml:space=\"preserve\" y=\"170\">Fakturadato: 20/12/10</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-size:10; stroke:none;\" x=\"401\" xml:space=\"preserve\" y=\"185\">Forfaldsdato: 28/12/10</text>"
            + "    </g>"
            + "    <g style=\"fill:rgb(79,79,79); font-family:sans-serif; font-size:10; font-weight:bold; shape-rendering:optimizeSpeed; stroke:rgb(79,79,79); text-rendering:geometricPrecision;\" transform=\"translate(36,36)\">"
            + "      <text style=\"clip-path:url(#clipPath1); stroke:none;\" x=\"9\" xml:space=\"preserve\" y=\"233\">TEKST</text>"
            + "      <text style=\"clip-path:url(#clipPath1); stroke:none;\" x=\"150\" xml:space=\"preserve\" y=\"233\">ANTAL</text>"
            + "      <text style=\"clip-path:url(#clipPath1); stroke:none;\" x=\"192\" xml:space=\"preserve\" y=\"233\">ENHED</text>"
            + "      <text style=\"clip-path:url(#clipPath1); stroke:none;\" x=\"371\" xml:space=\"preserve\" y=\"233\">PRIS</text>"
            + "      <text style=\"clip-path:url(#clipPath1); stroke:none;\" x=\"476\" xml:space=\"preserve\" y=\"233\">BELØB</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"9\" xml:space=\"preserve\" y=\"255\">test</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"172\" xml:space=\"preserve\" y=\"255\">2.0</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"192\" xml:space=\"preserve\" y=\"255\">stk.</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"349\" xml:space=\"preserve\" y=\"255\">kr 123,00</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"465\" xml:space=\"preserve\" y=\"255\">kr 246,00</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"284\" xml:space=\"preserve\" y=\"277\">Netto:</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"465\" xml:space=\"preserve\" y=\"277\">kr 246,00</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"284\" xml:space=\"preserve\" y=\"299\">Moms:</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"471\" xml:space=\"preserve\" y=\"299\">kr 61,50</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"284\" xml:space=\"preserve\" y=\"321\">I alt:</text>"
            + "      <text style=\"clip-path:url(#clipPath1); fill:black; font-weight:normal; stroke:none;\" x=\"465\" xml:space=\"preserve\" y=\"321\">kr 307,50</text>"
            + "    </g>"
            + "  </g>"
            + "</svg>";

        public void testEncode() throws UnsupportedEncodingException {
                
		String gwtaiEncodedString = Base64Util.encodeString(TEST_INPUT);
		String catalinaEncodedString = Base64Utils.toBase64(TEST_INPUT.getBytes("utf-8"));
		System.out.print(gwtaiEncodedString);
		assertEquals(catalinaEncodedString, gwtaiEncodedString);		
	}
	
	public void testDecode() throws UnsupportedEncodingException {
		String gwtaiDecodedString = Base64Util.decodeString(TEST_OUTPUT);
		String catalinaDecodedString = new String(Base64Utils.fromBase64(TEST_OUTPUT),"utf-8");
		
		assertEquals(catalinaDecodedString, gwtaiDecodedString);
	}
	
        /*public void testLongString() throws UnsupportedEncodingException {
		String encodedString = Base64Util.encodeString(TEST_LONG_STRING);
		String decodedString = new String(Base64Utils.fromBase64(encodedString), "utf-8");

		assertEquals(TEST_LONG_STRING, decodedString);
	}

        public void testLongString2() throws UnsupportedEncodingException {
		String encodedString = Base64Utils.toBase64(TEST_LONG_STRING.getBytes("utf-8"));
		String decodedString = Base64Util.decodeString(encodedString);

		assertEquals(TEST_LONG_STRING, decodedString);
	}*/

        public void testLongString3() throws UnsupportedEncodingException {
		String encodedString = Base64Util.encodeString(TEST_LONG_STRING);
		String decodedString = Base64Util.decodeString(encodedString);

		assertEquals(TEST_LONG_STRING, decodedString);
	}


}
