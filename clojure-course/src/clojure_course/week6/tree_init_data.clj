(ns clojure-course.week6.tree-init-data)

(defrecord Node [name find_me])

; edges have direction!
(defrecord Edge [node_from node_to])

(def all_nodes
  [
   (Node. "root" false)
   (Node. "node1" false)
   (Node. "node2" false)
   (Node. "node3" false)
   (Node. "node4" false)
   (Node. "node5" false)
   (Node. "node6" true)
   (Node. "node7" false)
   ]
  )

(def all_edges
  [
   (Edge. "root" "node1")
   (Edge. "root" "node5")
   (Edge. "root" "node7")
   (Edge. "node1" "node2")
   (Edge. "node2" "node3")
   (Edge. "node2" "node4")
   (Edge. "node5" "node6")
   ]
  )
