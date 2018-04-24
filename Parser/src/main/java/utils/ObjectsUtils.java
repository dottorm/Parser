package utils;

import model.Adf;
import model.Element;
import model.XfduManifest;

public class ObjectsUtils {
	
	public static String compareObjects(Element source, XfduManifest manifest){
		
		String result = "";
		
		String baseline = Messages.ERROR.getMessage();
		String cycle = Messages.ERROR.getMessage();
		String fullName = Messages.ERROR.getMessage();
		String genTime = Messages.ERROR.getMessage();
		String name = Messages.ERROR.getMessage();
		String orbit = Messages.ERROR.getMessage();
		String packetCount = Messages.ERROR.getMessage();
		String platform = Messages.ERROR.getMessage();
		String startTime = Messages.ERROR.getMessage();
		String stopTime = Messages.ERROR.getMessage();
		String surface = Messages.ERROR.getMessage();
		String timeliness = Messages.ERROR.getMessage();
		String type = Messages.ERROR.getMessage();
		
		Adf adf = (Adf) source;
		
		if(adf.getBaseLine().equals(manifest.getBaseLine())){
			baseline = Messages.OK.getMessage();
		}
		if(adf.getCycle().equals(manifest.getCycle())){
			cycle = Messages.OK.getMessage();
		}
		if(adf.getFullName().equals(manifest.getFullName())){
			fullName = Messages.OK.getMessage();
		}
		if(adf.getGenTime().equals(manifest.getGenTime())){
			genTime = Messages.OK.getMessage();
		}
		if(adf.getName().equals(manifest.getName())){
			name = Messages.OK.getMessage();
		}
		if(adf.getOrbit().equals(manifest.getOrbit())){
			orbit = Messages.OK.getMessage();
		}
		System.out.println(adf.getPacketCount()+" - "+manifest.getPacketCount());
		if(adf.getPacketCount().equals(manifest.getPacketCount())){
			packetCount = Messages.OK.getMessage();
		}
		if(adf.getPlatform().equals(manifest.getPlatform())){
			platform = Messages.OK.getMessage();
		}
		if(adf.getStartTime().equals(manifest.getStartTime())){
			startTime = Messages.OK.getMessage();
		}
		if(adf.getStopTime().equals(manifest.getStopTime())){
			stopTime = Messages.OK.getMessage();
		}
		if(adf.getSurface().equals(manifest.getSurface())){
			surface = Messages.OK.getMessage();
		}
		if(adf.getSurface().equals(manifest.getSurface())){
			surface = Messages.OK.getMessage();
		}
		if(adf.getTimeliness().equals(manifest.getTimeliness())){
			timeliness = Messages.OK.getMessage();
		}
		if(adf.getType().equals(manifest.getType())){
			type = Messages.OK.getMessage();
		}
		
		result = String.format(" Baseline: %s \n Cycle: %s \n FullName: %s \n Generation Time: %s \n Name: %s \n Orbit: %s \n Packet Count: %s \n Platform: %s \n Start Time: %s \n Stop Time: %s \n Surface: %s \n Timeliness: %s \n Type: %s \n", 
				baseline, cycle, fullName, genTime, name, orbit, packetCount, platform, startTime, stopTime, surface, timeliness, type);
		
		return result;
	}

}
