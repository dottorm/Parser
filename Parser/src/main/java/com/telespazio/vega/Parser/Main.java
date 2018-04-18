package com.telespazio.vega.Parser;

import utils.CheckName;

public class Main {

	public static void main (String[] a){
		String fileName = "S3A_TM_0_NAT____20171020T014744_20171020T033015_20171020T033151_6151_023_274______MAR_F_AL_002.SEN3";
		String pattern = "^S3[AB_]_TM_0_NAT____([0-9]{8}T[0-9]{6})_([0-9]{8}T[0-9]{6})_([0-9]{8}T[0-9]{6})_((([0-9]{4})_([0-9]{3})_([0-9]{3})_(([0-9]{4})|(_{4})))|([0-9a-zA-Z_]{17}))_(LN1|LN2|LN3|MAR|SVL|TST|___)_(((F|O|_)_(NR|NT|ST|AL|__)_([a-zA-Z0-9_]{3}))|_{8})\\.SEN3$";
		System.out.println(CheckName.chekName(fileName, pattern));
		
		Engine engine = new Engine();
		
	}
}
