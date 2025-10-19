package labo2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributuak
	protected Node<T> last;  // azkenengoaren erreferentzia
	protected String deskr;  // deskribapena
	protected int count;

	public DoubleLinkedList() {
		last = null;
		deskr = "";
		count = 0;
	}
	
	public void setDeskr(String ize) {
	  deskr = ize;
	}

	public String getDeskr() {
	  return deskr;
	}

	public T removeFirst() {
	// listako lehen elementua kendu da
	// Aurrebaldintza: 
		// KODEA OSATU ETA KOSTUA KALKULATU      O(1)
		Node<T> first;
		if (this.last == null) //lista hutsa denean
			return null;
		if (this.last.next == this.last) { //elementu bakarra
				first = this.last;
				this.last = null;
			} else { // hainbat elementu
				first = this.last.next;
				this.last.next = first.next;
				first.next.prev = last;
			}
	return first.data;
	}

	public T removeLast() {
	// listako azken elementua kendu da
	// Aurrebaldintza: 
		// KODEA OSATU ETA KOSTUA KALKULATU      O(1)
		Node<T> emaitza = this.last;
		if (this.last == null) //lista hutsa denean
			return null;
		if (this.last.next == this.last) { //elementu bakarra
			last=null;
		} else { // hainbat elementu
			emaitza.next.prev = emaitza.prev;
			emaitza.prev.next = emaitza.next;
			last = emaitza.prev;
		}
		return emaitza.data;
    }


	public T remove(T elem) {
	// Aurrebaldintza: 
	// Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
        //  bueltatuko du (null ez baldin badago)
		// KODEA OSATU ETA KOSTUA KALKULATU     O(n) kasurik txarrenean
		Node<T> unekoa = this.last;
		Node<T> emaitza = null;
		if (this.last == null) //lista hutsa denean
			return null;
		do{
			unekoa=unekoa.next;
			if(unekoa.data.equals(elem)) {
				emaitza = unekoa;
				unekoa.next.prev = unekoa.prev;
				unekoa.prev.next = unekoa.next;
				if(unekoa == this.last) { //azkena bada
					this.last = unekoa.prev;
				}
			}
		}while(emaitza == null && unekoa != this.last);
		
		if (emaitza==null) return null;
		else return emaitza.data;
        }
		
	public void removeAll(T elem) {
	// Aurrebaldintza: 
	// Balio zehatz baten agerpen guztiak ezabatzen ditu
	
		// KODEA OSATU ETA KOSTUA KALKULATU      O(n)
		if (this.last == null) // lista hutsa denean
	        return;
	    Node<T> unekoa = this.last.next; // lehenengo elementua
	    Node<T> hasiera = unekoa;        // hasierako nodoa gogoratu loopetik ondo irtetzeko
	    do {
	        Node<T> hurrengoa = unekoa.next; // gorde hurrengo nodoa
	        if (unekoa.data.equals(elem)) {
	            // nodoa ezabatu
	            unekoa.next.prev = unekoa.prev;
	            unekoa.prev.next = unekoa.next;
	            // Azkena bada, last eguneratu
	            if (unekoa == this.last) {
	                this.last = unekoa.prev;
	            }
	            // lista hutsik gelditzen bada
	            if (unekoa.next == unekoa) {
	                this.last = null;
	            }
	            // hasierakoa bazen, hasiera eguneratu
	            if (unekoa == hasiera) {
	                hasiera = hurrengoa;
	            }
	        }
	        unekoa = hurrengoa; // hurrengo nodora pasatu
	    } while (this.last != null && unekoa != hasiera);
	}

	public T first() {
	// listako lehen elementua ematen du
	   // KODEA OSATU ETA KOSTUA KALKULATU
		if (this.last == null) { // lista hutsa denean
	        return null;
	    } else {
	        return this.last.next.data; 
	    }
	}
	public T last() {
	// listako azken elementua ematen du
	   // KODEA OSATU ETA KOSTUA KALKULATU
	}

	public DoubleLinkedList<T> clone(){
		// Zerrendaren kopia bat itzultzen du (ez du punteroa bikoizten)
	   // KODEA OSATU ETA KOSTUA KALKULATU		
	} 

	public boolean contains(T elem) {
	// Egiazkoa bueltatuko du aurkituz gero, eta false bestela
		      if (isEmpty())
		          return false;

		      		// KODEA OSATU ETA KOSTUA KALKULATU
		   }

	public T find(T elem) {
	// Elementua bueltatuko du aurkituz gero, eta null bestela

		// KODEA OSATU ETA KOSTUA KALKULATU
	}

	public boolean isEmpty() { 
	// KODEA OSATU ETA KOSTUA KALKULATU
	}
	
	public int size() { 
	// KODEA OSATU ETA KOSTUA KALKULATU
	}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 

		// KODEA OSATU 
	   } // private class
		
		
		public void adabegiakInprimatu() {
			System.out.println(this.toString());
		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "DoubleLinkedList " + result + "]";
		}

}

