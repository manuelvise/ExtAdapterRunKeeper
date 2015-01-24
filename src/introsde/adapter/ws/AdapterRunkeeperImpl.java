package introsde.adapter.ws;

import introsde.adapter.model.Profile;
import introsde.adapter.util.HttpGetRequestRK;
import introsde.adapter.model.Activities;
import introsde.adapter.model.Weights;
import introsde.adapter.util.RunKConstants;

import java.io.IOException;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

//Service Implementation

@WebService(endpointInterface = "introsde.adapter.ws.ExtAdapterRunkeeper", serviceName = "AdapterRunkeeperService")
public class AdapterRunkeeperImpl implements AdapterRunkeeper {

	@Override
	public Activities getFitnessActivities(String accessToken) {

		HttpGetRequestRK activitiesRequest = new HttpGetRequestRK(
				RunKConstants.REST_URL, "fitnessActivities", accessToken,
				RunKConstants.MEDIA_FITNESS_ACTIVITY_FEED);
		String responseFromRunkeeper = activitiesRequest.getResponse();

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(responseFromRunkeeper, Activities.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Weights getWeight(String accessToken) {
		HttpGetRequestRK activitiesRequest = new HttpGetRequestRK(
				RunKConstants.REST_URL, "weight", accessToken,
				RunKConstants.MEDIA_WEIGHT_MEASUREMENT_FEED);
		String responseFromRunkeeper = activitiesRequest.getResponse();

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(responseFromRunkeeper, Weights.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getUserId(String accessToken) {
		HttpGetRequestRK activitiesRequest = new HttpGetRequestRK(
				RunKConstants.REST_URL, "user", accessToken,
				RunKConstants.MEDIA_USER);
		String responseFromRunkeeper = activitiesRequest.getResponse();

		Long userId = null;
		JSONObject jsonToken = new JSONObject(responseFromRunkeeper);
		userId = (Long) jsonToken.get("userID");
		return userId;
	}

	@Override
	public Profile getUser(String accessToken) {
		HttpGetRequestRK activitiesRequest = new HttpGetRequestRK(
				RunKConstants.REST_URL, "profile", accessToken,
				RunKConstants.MEDIA_PROFILE);
		String responseFromRunkeeper = activitiesRequest.getResponse();

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(responseFromRunkeeper, Profile.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
