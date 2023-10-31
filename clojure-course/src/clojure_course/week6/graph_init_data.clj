(ns clojure-course.week6.graph_init_data)

; we have nodes A-E and edges
; the task is to visit all nodes (literally, have them all marked as "visited")

(defrecord Node [name])
(defrecord Edge [node1 node2])

(def all_nodes
  [
   (Node. "A")
   (Node. "B")
   (Node. "C")
   (Node. "D")
   (Node. "E")
   ]
  )

(def all_edges
  [
   (Edge. "A" "B")
   (Edge. "A" "C")
   (Edge. "C" "B")
   (Edge. "C" "E")
   (Edge. "B" "D")
   ]
  )



