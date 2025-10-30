package labo2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// hasieran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU

	}

public void addToRear(T elem) {
	// bukaeran gehitu
	//KOSTUA: O(1); konstantea
		Node<T> berria = new Node<T>(elem);
        if (this.last == null ) {
			this.last = berria;
			count = 1;
		} else if (last.next == null) {
			last.next = berria;
			berria.prev = last;
			berria.next = last;
			last.prev = berria;
			this.last = berria;
			this.count = this.count + 1;
		} else {
			Node<T> first = last.next;
			this.last.next = berria;
			berria.prev = this.last;
			berria.next = first;
			first.prev = berria;
			last = berria;
			this.count = this.count + 1;
		}
	}

	
	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU
	}

}

