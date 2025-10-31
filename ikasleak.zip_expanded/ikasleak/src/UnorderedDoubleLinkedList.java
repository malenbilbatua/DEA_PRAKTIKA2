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
			this.count = 1;
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
	//target elementua eta gero gehitu
	//KOSTUA: n = zerrendaren aldagai kopurua izanda, O(n); lineala				
		Node<T> berria = new Node<T>(elem);
		if (last.next == null && last.data.equals(target)) {
			this.addToRear(elem);
		} else {
			boolean aurkitua = false;
			Node<T> unekoa = last.next;
			Node<T> hurrengoa = unekoa.next;
			while (unekoa != last && !aurkitua) {
				if (unekoa.data.equals(target)) {
					aurkitua = true;
				} else {
					unekoa = hurrengoa;
					hurrengoa = hurrengoa.next;
				}
			}
			if (last.data.equals(target)) {
				Node<T> first = last.next;
				berria.next = first;
				last.next = berria;
				first.prev = berria;
				berria.prev = last;
				last = berria;
				this.count = this.count + 1;
			} else if (aurkitua && unekoa != last) {
				berria.next = hurrengoa;
				unekoa.next = berria;
				hurrengoa.prev = berria;
				berria.prev = unekoa;
				this.count = this.count + 1;
			}
		}
	}
}


