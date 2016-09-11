package com.david.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.david.dto.PublicKeyTypeEnum;
import com.david.utils.RsaCodingUtil;
import com.david.utils.RsaReadUtil;

public class AppTest {

	private static Logger logger = Logger.getLogger(AppTest.class);
	private static final String pb_api_795045_29032 = "bfkey_795045@@29302.cer";
	private static final String pb_dcp_795045_30666 = "bfkey_795045@@30666.cer";
	private static final String pb_api_795048_29037 = "bfkey_795048@@29307.cer";
	private static final String pb_dcp_795048_30667 = "bfkey_795048@@30667.cer";
	private static final String parentPath = "C:" + File.separator + "Users" + File.separator + "Administrator"
			+ File.separator + "Desktop" + File.separator + "baofoo_new" + File.separator;

	private static final String logger_publickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCV47UJ/bMko2Ur5vxOsaCt1GdP6Tmo8LhKJMuKsPkpKaKoyUuQvIQH5a0RErSIzBbQYA0GG+/bKnFMVVneKxEgCmV2PcwLN2CAjMt3Cn4V7sgCV3vpNp3gHabvEMx/WpcCRBZiqNDyVye18wiGdKwA/gOsxPaoNfG/tg6iDET6iQIDAQAB";

	private String getPublickKeyPath(PublicKeyTypeEnum type) {
		String path = StringUtils.EMPTY;
		switch (type) {
		case PB_API_795045_29302:
			path = parentPath + pb_api_795045_29032;
			break;
		case PB_DCP_795045_30666:
			path = parentPath + pb_dcp_795045_30666;
			break;
		case PB_API_795048_29307:
			path = parentPath + pb_api_795048_29037;
			break;
		case PB_DCP_795048_30667:
			path = parentPath + pb_dcp_795048_30667;
			break;
		default:
			break;
		}

		return path;
	}

	@Test
	public void testPublicKeyBase64Str() {
		try {
			String pubCerPath = getPublickKeyPath(PublicKeyTypeEnum.PB_DCP_795045_30666);
			String encryptDataString = "82eb19a00a9d7beeafbe0c1c5b55d878e3d7a565689044f841df2048ea8fe3d54c5c6b4e2c20eb2b964379086179981101167b506f3e2139f9f8e0e26956f92658c2902dbaffc09ab843a816299ccefe9ab4049f7de86bc63b7f4f04c8700eb318a5eb313c9e91a066ae7eae144895321202c2b0bd239de524c9e7cff02acab10a1d2f0d3e11577b3f57570a475968de8ab652336c2977f607da573aea47bb612f52e7046d9b1e9bae61ae75d8269da76d03ec1fe6aff9e98d156f72f6c6a01462979bd0554e57b739eb781af8e483e9fe2ea31a4f0d40ee647d52c18ec4a7a087696886a6ef7b2564feea16da8975faa4e0e9fc3ae8e3ec615c127cb1aba8aa52b614c44736ea58382b6476dc1ba4d183c79ed9852408eb0c51ad0cfcba5fcb5d871f0291e58cd450aefe0c6308c90b69674df5a013b4bb34c6e3d5f2b8ce5427cb641d228098fdcb8d0aaf3f6702f5148aac0ee09361251f0c8c6c78d7e554f6f9a2ef8dcd1929301e9a9b8886ce94ea41ce36013bd0dedb4af40cbeecc43d0cfa4c59fcecb2af7a98f72ee54fc8b88c7076f1a522a9b7fd68051a04e8cd311e39b190717c577c1f26de5a5b72752726de39f2604005f9bc5b6fba0c3aadde4275814e03d1880f88b496f51b363d2416af16551705d3b3211e68bff305a999e724b10f3ac8f04b62e4b32ebf2e2ea878684ded863cec7e8e14070996f31f5a25bee2aee2c7c771676fcaebe0d823d8bc36b1e443540bd089c1746e7a07a9e1dda41c53ca1eaa4c3bebbb02b9195312d01c0632d988fc725e85ffff204c692c044a7dc0b35ef5188dd0fc679e4b286813bba2cc64c3e233884fe91ba469339f4b78b62a143dbb751d16524f45f0d581d26ce9c8980844390fb0cb7cbfebd26b5f7cd7629941b33fe4af728b4bd024a4686e2164a0bd07cfd7c23be16dc452d27053e50691ce3575a1120df641e5e5ede99e3c388b7c96c3c408f24db37250d559bc50e6a7f57678f19a6b0e4dc1c6fd6d8bcfe37daff54ed42a2a73e69de4a57ab59adad1a799838ca4779101c8fe259d5367940c6df0d19ad0b450e9ba121f89210cba910c94ea63ebfbaea0b6d29057799a0e0a0a204041d312764f354c5bf582b27ed339447e8f99aed8d6eeabcf2502230d129045919064377bb8b1ed1a90a9106077e0b602b67265a48c68672778c8afab7e4c8982b943c810620a44e7db5da9daab750efa7ae6701be821ac63ad9ef5c4c500b962824ff8fa83d42ab3310814e2190be527f3b2be437828f781d09147195cf589a5db38faa533a952e4b2fbcd780f26d6008c2320567468c8317e8a5b6aabe4965b06d9eecd044c3012dcdf25cb23aa0c2317dd0e7a33f7e67570c93ba690565427c11511c8e33321e50bf811844a52b307cd9ae46cda7df49a8b66969b57cb5e8d38cd9ef3935c5a60";
			String result = RsaCodingUtil.decryptByPubCerFile(encryptDataString, pubCerPath);
			String result2 = new String(Base64.decodeBase64(result), "UTF-8");
			System.err.println(result);
			System.out.println();
			System.err.println(result2);

			PublicKey publicKey = RsaReadUtil.getPublicKeyFromFile(pubCerPath);
			String base64PublickeyString = Base64.encodeBase64String(publicKey.getEncoded());
			System.out.println("base64PublickeyString: ");
			System.out.println(base64PublickeyString);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

	}

	@Test
	public void testPublickey() {
		for (PublicKeyTypeEnum type : PublicKeyTypeEnum.values()) {
			String pubCerPath = getPublickKeyPath(type);
			PublicKey publicKey = RsaReadUtil.getPublicKeyFromFile(pubCerPath);
			String base64PublickeyString = Base64.encodeBase64String(publicKey.getEncoded());
			System.out.println("base64PublickeyString: ");
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException ex) {
				logger.error(ex.getMessage(), ex);
			}
			System.err.println(base64PublickeyString);
		}
	}

}
