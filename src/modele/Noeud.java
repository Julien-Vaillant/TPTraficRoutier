package modele;

import java.util.ArrayList;
import java.util.List;

public class Noeud {
   /**colonne du noeud*/
   double x;
   /**ligne du noeud*/
   double y;
   /**liste des voisins accessibles*/
   ArrayList<Noeud> noeudsAccessibles;
   /**liste des arcs entrants*/
   ArrayList<Arc> arcEntrants;
   /**liste des arcs sortants*/
   ArrayList<Arc> arcSortants;
   /**liste des voitures sur noeud*/
   public ArrayList<Voiture> cars;
   /**id du noeud double construit a partir des coordonnes = (x.y)*/
   String id;
   /**noeud principal ou secondaire*/
   boolean principal;

   public boolean reserve = false;

	
   /**constructeur initialisant les coordonnées du noeud et son type*/
   Noeud(double _x, double _y)
   {
      x = _x;
      y = _y;
      principal = true;
      id = "("+x+";"+y+")";
      noeudsAccessibles = new ArrayList<>();
      arcEntrants = new ArrayList<>();
      arcSortants = new ArrayList<>();
      cars = new ArrayList<>();
   }

   /**constructeur initialisant les coordonnées du noeud et son type*/
   Noeud(double _x, double _y, boolean _principal)
   {
      this(_x, _y);
      principal = _principal;
   }

	
   /**affiche les coordonnees d'un noeud */
   public String toString()
   {		
	return "noeud (" + x +"," + y + ")" ;
   }
   
   /**deux noeuds sont egaux s'ils ont la meme id*/
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Noeud autre = (Noeud)o;
      return id==autre.id;
   }

   /**ajoute une voiture dans le carrefour.
    * si plusieurs sont presentes -> accident*/
   public void addCar(Voiture car) 
   {
      cars.add(car);

      if(cars.size()>1)
      {

	 //TODO: mettre toutes les voitures du noeud en accident
          for(int i=0;i<cars.size()-1;i++){
              for(int j=i;j<cars.size();j++){
                 if(cars.get(i).getNoeudSuivi()==cars.get(i).getNoeudSuivi()){
                    cars.get(i).setAccident(true);
                    cars.get(j).setAccident(true);
                 }
              }
          }
          //
      }
   }

   /**retrait d'une voiture du carrefour.*/
   public void removeCar(Voiture car) 
   {
         //boolean retraitOk = cars.remove(car);
         //if(!retraitOk) System.out.println("erreur dans le retrait de voiture " + this);
         cars.remove(car);
   }

   public double getX() { return x; }
   public double getY() { return y; }
   public List<Arc> getArcSortants() { return arcSortants; }	
   public boolean isPrincipal() {return principal;}
   public void addArcEntrant(Arc arc) {arcEntrants.add(arc);}
   public void addArcSortant(Arc arc) {arcSortants.add(arc);}
   public int getNbCars() {return cars.size();}
}
