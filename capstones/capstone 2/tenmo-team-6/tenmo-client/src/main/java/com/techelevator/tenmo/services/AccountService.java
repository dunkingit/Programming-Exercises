package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.*;
import com.techelevator.util.BasicLogger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.List;

public class AccountService {
    private final RestTemplate restTemplate;
    private final UserCredentials userCredentials;
    private final AuthenticatedUser currentUser;
    private final String apiUrl;

    public AccountService(RestTemplate restTemplate, UserCredentials userCredentials, AuthenticatedUser currentUser, String apiUrl) {
        this.restTemplate = restTemplate;
        this.userCredentials = userCredentials;
        this.currentUser = currentUser;
        this.apiUrl = apiUrl;
    }

    public int getUserId() {
        try {
            ResponseEntity<Integer> response = restTemplate.exchange(apiUrl + "account/userid", HttpMethod.GET, createHttpEntity(null), Integer.class);
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return 0;
        }
    }

    public int getAccountId() {
        try {
            ResponseEntity<Integer> response = restTemplate.exchange(apiUrl + "account/accountid", HttpMethod.GET, createHttpEntity(null), Integer.class);
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return 0;
        }
    }

    public double getBalance() {
        try {
            ResponseEntity<Double> response = restTemplate.exchange(apiUrl + "account/balance", HttpMethod.GET, createHttpEntity(null), Double.class);
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return 0;
        }
    }

    public List<User> getUsers() {
        try {
            ResponseEntity<List<User>> response = restTemplate.exchange(apiUrl + "users/list", HttpMethod.GET, createHttpEntity(null), new ParameterizedTypeReference<List<User>>(){});
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return List.of();
        }
    }

    public List<Transfer> getSentTransfers() {
        try {
            ResponseEntity<List<Transfer>> response = restTemplate.exchange(apiUrl + "users/sent", HttpMethod.GET, createHttpEntity(null), new ParameterizedTypeReference<List<Transfer>>(){});
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return List.of();
        }
    }

    public List<Transfer> getReceivedTransfers() {
        try {
            ResponseEntity<List<Transfer>> response = restTemplate.exchange(apiUrl + "users/received", HttpMethod.GET, createHttpEntity(null), new ParameterizedTypeReference<List<Transfer>>(){});
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return List.of();
        }
    }

    public String sendTransfer(Transfer transfer) {
        try {
            ResponseEntity<String> response = restTemplate.exchange(apiUrl + "users/transfer", HttpMethod.POST, createHttpEntity(transfer), String.class);
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return "No go";
        }
    }

    public List<Transfer> getPendingTransfers() {
        try {
            ResponseEntity<List<Transfer>> response = restTemplate.exchange(apiUrl + "users/pending", HttpMethod.GET, createHttpEntity(null), new ParameterizedTypeReference<List<Transfer>>(){});
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return List.of();
        }
    }

    public String updateTransfer(int id, int newstatus) {
        String url = apiUrl + "users/" + String.valueOf(id) +"/" + newstatus;
        try {
            ResponseEntity<String> response = restTemplate.exchange(apiUrl + "users/", HttpMethod.POST, createHttpEntity(null), String.class);
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return "No go";
        }
    }

    private <T> HttpEntity<T> createHttpEntity(T body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }
}




//package com.techelevator.tenmo.services;
//
//import com.techelevator.tenmo.model.*;
//import com.techelevator.util.BasicLogger;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.*;
//import org.springframework.web.client.ResourceAccessException;
//import org.springframework.web.client.RestClientResponseException;
//import org.springframework.web.client.RestTemplate;
//
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.techelevator.tenmo.App.API_BASE_URL;
//
//public class AccountService{
//    private final RestTemplate restTemplate;
//    private UserCredentials userCredentials;
//    private AuthenticatedUser currentUser;
//
//    private String API_BASE_URL;
//
//    public AccountService(RestTemplate restTemplate, UserCredentials userCredentials, AuthenticatedUser currentUser,
//    String url) {
//        this.restTemplate = restTemplate;
//        this.userCredentials = userCredentials;
//        this.currentUser = currentUser;
//        this.API_BASE_URL = url;
//    }
//
//    public int getUserId() {
//        int num = 0;
//        try{
//            ResponseEntity<Integer> response = restTemplate.exchange(API_BASE_URL + "account/userid", HttpMethod.GET,
//                    makeAuthEntity(), Integer.class);
//            num = response.getBody();
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return num;
//    }
//
//    public int getAccountId() {
//        int num = 0;
//        try{
//            ResponseEntity<Integer> response = restTemplate.exchange(API_BASE_URL + "account/accountid", HttpMethod.GET,
//                    makeAuthEntity(), Integer.class);
//            num = response.getBody();
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return num;
//    }
//
//    public double getBalance() {
//        double newresponse = 0;
//        try{
//             ResponseEntity<Double> response = restTemplate.exchange(API_BASE_URL + "account/balance", HttpMethod.GET,
//                    makeAuthEntity(), Double.class);
//            newresponse = response.getBody();
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return newresponse;
//    }
//
//    public List<User> getUsers() {
//        List<User> listUsers = null;
//        try{
//            ResponseEntity<List<User>> response = restTemplate.exchange(API_BASE_URL + "users/list", HttpMethod.GET,
//                    makeAuthEntity(), new ParameterizedTypeReference<List<User>>(){});
//            listUsers = response.getBody();
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return listUsers;
//    }
//
//    public List<Transfer> getSentTransfers() {
//        List<Transfer> listUsers = null;
//        try{
//            ResponseEntity<List<Transfer>> response = restTemplate.exchange(API_BASE_URL + "users/sent", HttpMethod.GET,
//                    createHttpEntity(), new ParameterizedTypeReference<List<Transfer>>(){});
//            listUsers = response.getBody();
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return listUsers;
//    }
//
//
//    public List<Transfer> getReceivedTransfers() {
//        List<Transfer> listUsers = null;
//        try{
//            ResponseEntity<List<Transfer>> response = restTemplate.exchange(API_BASE_URL + "users/received", HttpMethod.GET,
//                    createHttpEntity(), new ParameterizedTypeReference<List<Transfer>>(){});
//            listUsers = response.getBody();
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return listUsers;
//    }
//
//    public String sendTransfer(Transfer transfer) {
//        try{
//            ResponseEntity<String> response = restTemplate.exchange(API_BASE_URL  + "users/transfer", HttpMethod.POST,
//                    createHttpEntity(transfer), String.class);
//            return response.getBody();
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return "No go";
//    }
//
//    private <T> HttpEntity<T> createHttpEntity(T body) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(currentUser.getToken());
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return new HttpEntity<>(body, headers);
//    }

//    private HttpEntity<UserCredentials> makeAuthEntity() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(this.currentUser.getToken());
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<UserCredentials> entity = new HttpEntity<>(userCredentials, headers);
//        return entity;
//    }
//
//
//    private HttpEntity<Transfer> setEntity(Transfer transfer) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(this.currentUser.getToken());
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);
//        return entity;
//    }
//}
//