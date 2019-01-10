package it.polito.dp2.RNS.sol2;


import it.polito.dp2.RNS.*;
import it.polito.dp2.RNS.lab2.BadStateException;
import it.polito.dp2.RNS.lab2.ModelException;
import it.polito.dp2.RNS.lab2.ServiceException;
import it.polito.dp2.RNS.lab2.UnknownIdException;

import java.util.*;

public class PathFinder implements it.polito.dp2.RNS.lab2.PathFinder {

	Map<String,List<String>> graph = null;

	@Override
	public boolean isModelLoaded() {
		return graph==null;
	}

	@Override
	public void reloadModel() throws ServiceException, ModelException {

		RnsReader rnsReader=null;
		try {
			rnsReader = RnsReaderFactory.newInstance().newRnsReader();
		} catch (RnsReaderException e) {
			e.printStackTrace();
		}

		graph = new HashMap<>();

		for(PlaceReader placeReader:rnsReader.getPlaces(null)){
			graph.put(placeReader.getId(),new ArrayList<>());
		}

		for(ConnectionReader connectionReader:rnsReader.getConnections()){
			graph.get(connectionReader.getFrom().getId()).add(connectionReader.getTo().getId());
		}
		
	}

	@Override
	public Set<List<String>> findShortestPaths(String source, String destination, int maxlength) throws UnknownIdException, BadStateException, ServiceException {
		return null;
	}
}
