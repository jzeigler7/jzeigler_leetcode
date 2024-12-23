class UndergroundSystem {
    //create static hash table mapping IDs to tuples containing:
    //1. the current starting station of that Customer
    //2. current starting time of that customer

    //create another static hash table mapping station names to pairs containing internap hash tables
    //mapping each other station to pairs containing 1. total minutes traveled by all customers from the corresponding start-to-end 
    //2. current # of data points (to help quickly calculate the new average)

    Map<Integer, Pair<String, Integer>> customersMap = new HashMap<Integer, Pair<String, Integer>>();
    Map<String,Map<String,Pair<Integer, Integer>>> stationsMap = new HashMap<String,Map<String,Pair<Integer, Integer>>>();

    public UndergroundSystem() {
            //contains hash table mapping IDs to tuples containing:
    //1. the current starting station of that Customer
    //2. current starting time of that customer


    //contains another hash table mapping station names to pairs containing internap hash tables
    //mapping each other station to pairs containing 1. total minutes traveled by all customers from the corresponding start-to-end 
    //2. current # of data points (to help quickly calculate the new average)
    customersMap = new HashMap<Integer, Pair<String, Integer>>();
    stationsMap = new HashMap<String,Map<String,Pair<Integer, Integer>>>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        //this modifies the customers hashtable to a pair reflecting this station and start time
        customersMap.put(id, new Pair<String, Integer>(stationName, t));
        
    }
    
    public void checkOut(int id, String stationName, int t) {
        //this modifies the stations hash table to update the total time based on the difference between the given end time and the stored start time for that customer in the customers hashtable. also increments the number of datapoints for accurate mean calculation
        //need to know: start station, end station, curr data stored in 2D stationmap for the given pair (or create empty data if not present)
        // start time, start-end total time, start-end total datapoints

        String startStation = customersMap.get(id).getKey();
        int startTime = customersMap.get(id).getValue();
        if (!stationsMap.keySet().contains(startStation)) {
            stationsMap.put(startStation, new HashMap<String,Pair<Integer,Integer>>());
        }
        if (!stationsMap.get(startStation).keySet().contains(stationName)) {
            stationsMap.get(startStation).put(stationName, new Pair<Integer, Integer>(0,0));
        }
        Pair<Integer,Integer> endStationPairData = stationsMap.get(startStation).get(stationName);
        int pathTotalTime = endStationPairData.getKey();
        int pathPoints = endStationPairData.getValue();
        int timeDiff = t - startTime;
        stationsMap.get(startStation).put(stationName, new Pair<Integer, Integer>(pathTotalTime + timeDiff,pathPoints + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        //uses the stations hashtable to return the quotient of total minutes traveled and the # of datapoints
        Pair<Integer,Integer> pairData = stationsMap.get(startStation).get(endStation);
        double pathTotalTime = pairData.getKey();
        int pathPoints = pairData.getValue();
        return pathTotalTime / pathPoints;
        


        
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */