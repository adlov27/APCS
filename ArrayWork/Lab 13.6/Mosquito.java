public class Mosquito extends Critter {
  private int lifespan;
  boolean cowbitten;
  
  public Mosquito () { super(Color.BLUE) }
  public Mosquito(Color color) {
    super(color);
    lifespan = 0;
    cowbitten = false;
  }
  
  public void processActors(ArrayList<Actors> actors) {
    if(lifespan  >= 6) {
      if(cowbitten) {
        MosquitoEgg egg = new MosquitoEgg();
        egg.putSelfInGrid(getGrid(), getLocation());
        removeSelfFromGrid();
        return;
      } else {
        removeSelfFromGrid();
        return;
      }
    }
    lifespan ++;
  }
  
  public Location selectMoveLocation(ArrayList<Locations> locs) {
    ArrayList<Location> bestlocs;
    
    int minimum = DistanceBetweenLocations(this, goodloc);
    int newdistance;
    for(Location goodloc : locs) {
      if((newdistance = DistanceBetweenLocations(this, goodloc)) >= minimum) {
        minimum = newdistance;
      }
    }
    for(Location goodloc : locs) {
      if(goodloc.contains(minimum)) {
        bestlocs.add(goodloc);
      }
    }
    return super.selectMoveLocation(bestlocs);
  }
  
   public void makeMove(Location loc) {
        setDirection(getLocation().getDirectionToward(loc));
        if(loc != null)
          cowbitten = true;
        super.makeMove(loc);
    }
  
  public int DistanceBetweenLocations(Location loc1, Location loc2) {
    return distance(loc1, loc2);
  }
}
