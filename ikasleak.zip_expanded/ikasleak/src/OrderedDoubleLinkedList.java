package labo2;

public class OrderedDoubleLinkedList<T extends Comparable<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
public void add(T elem){	//ORDENA: String motan Alfabetikoki
	//Elementua lista ordenatu batean gehitu
	//KOSTUA: O(1)
		Node<T> berria = new Node<T>(elem);
		if (this.last == null) { //elementurik ez
			this.last = berria;
			this.count = 1;
		} else if (this.last.next == null) { //elementu bat
			if ((this.last.data).compareTo(berria.data) <= 0) { //last.data <= elem 
				this.last.next = berria;
				berria.prev = last;
				berria.next = this.last;
				this.last.prev = berria;
				last = berria;
				count = count + 1;
			} else if ((this.last.data).compareTo(berria.data) > 0) { //last.data > elem
				this.last.prev = berria;
				berria.next = this.last;
				this.last.next = berria;
				berria.prev = this.last;
				count = count + 1;
			}
		} else { //2+ elementu
			boolean aurkitua = false;
			boolean lehenengoa = false;
			Node<T> unekoa = this.last.next;
			Node<T> hurrengoa = unekoa.next;
			while (unekoa != this.last && !aurkitua && !lehenengoa) {
				if (unekoa == this.last.next && (unekoa.data).compareTo(berria.data) > 0) {
					lehenengoa = true;
				} else if ((unekoa.data).compareTo(berria.data) <= 0 && (hurrengoa.data).compareTo(berria.data) > 0) {
						aurkitua = true;
				} else {
						unekoa = hurrengoa;
						hurrengoa = hurrengoa.next;
				}
			}
			if (unekoa == this.last && (unekoa.data).compareTo(berria.data) <= 0) {
				unekoa.next = berria;
				berria.prev = unekoa;
				hurrengoa.prev = berria;
				berria.next = hurrengoa;
				this.last = berria;
				count = count + 1;
			} else if (aurkitua) {
				unekoa.next = berria;
				berria.prev = unekoa;
				hurrengoa.prev = berria;
				berria.next = hurrengoa;
				count = count +1;
			} else if (lehenengoa) {
				unekoa.prev = berria;
				berria.next = unekoa;
				this.last.next = berria;
				berria.prev = this.last;
				count = count + 1;
			}
		} 
	}

	public OrderedDoubleLinkedList<T> intersection(OrderedDoubleLinkedList<T> zerrenda){
		OrderedDoubleLinkedList<T> emaitza = new OrderedDoubleLinkedList<T>();
		boolean amaituta = false;
		Node<T> unekoa1 = this.last.next;
		Node<T> unekoa2 = zerrenda.last.next;
		while(unekoa1 != this.last && unekoa2 != zerrenda.last) {
			//(1) adabegia lortu
			if ((unekoa1.data).compareTo(unekoa2.data) == 0) { //unekoa1 == unekoa2
				emaitza.add(unekoa1.data);
				unekoa1 = unekoa1.next;
				unekoa2 = unekoa2.next;				
			} else if ((unekoa1.data).compareTo(unekoa2.data) > 0) { //unekoa1 > unekoa2
				unekoa2 = unekoa2.next;
			} else if ((unekoa1.data).compareTo(unekoa2.data) < 0) { //unekoa1 < unekoa2
				unekoa1 = unekoa1.next;
			}
		}
		if (unekoa1 == this.last && unekoa2 == zerrenda.last) {
			if((unekoa1.data).compareTo(unekoa2.data) == 0) {
				emaitza.add(unekoa1.data);
			}
		} else if (unekoa1 == this.last && unekoa2 != zerrenda.last) {
			while (unekoa2 != zerrenda.last && !amaituta) {
				if ((unekoa1.data).compareTo(unekoa2.data) < 0) {}
				else if ((unekoa1.data).compareTo(unekoa2.data) == 0) {
					emaitza.add(unekoa1.data);
					amaituta = true;
				} else if ((unekoa1.data).compareTo(unekoa2.data) > 0) {
					unekoa2 = unekoa2.next;
				}
			}
		}else if (unekoa1 != this.last && unekoa2 == zerrenda.last) {
			while (unekoa1 != this.last && !amaituta) {
				if ((unekoa2.data).compareTo(unekoa1.data) < 0) {}
				else if ((unekoa2.data).compareTo(unekoa1.data) == 0) {
					emaitza.add(unekoa1.data);
					amaituta = true;
				} else if ((unekoa2.data).compareTo(unekoa1.data) > 0) {
					unekoa1 = unekoa1.next;
				}
			}
		}
		return emaitza;
	}


}



