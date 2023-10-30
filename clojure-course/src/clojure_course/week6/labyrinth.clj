(ns clojure-course.week6.labyrinth
  )


(defrecord Node [name find_me])

; edges have direction!
(defrecord Edge [node_from node_to])

(def all_nodes
  [
   (Node. "5;0" false)
   (Node. "5;2" false)
   (Node. "5;4" false)
   (Node. "4;2" false)
   (Node. "4;4" false)
   (Node. "5;5" false)
   (Node. "2;1" false)
   (Node. "0;0" false)
   (Node. "2;3" false)
   (Node. "0;3" false)
   (Node. "2;5" false)
   (Node. "0;5" true)
   (Node. "3;5" false)
   ]
  )

(def all_edges
  [
   (Edge. "5;0" "5;2")
   (Edge. "5;2" "5;4")
   (Edge. "5;2" "4;2")
   (Edge. "5;4" "4;4")
   (Edge. "5;4" "5;5")
   (Edge. "5;0" "2;1")
   (Edge. "2;1" "0;0")
   (Edge. "2;1" "2;3")
   (Edge. "2;3" "0;3")
   (Edge. "2;3" "2;5")
   (Edge. "2;5" "0;5")
   (Edge. "2;5" "3;5")
   ]
  )

(defn dfs-search
  [start-node]
  (let [visited (set [start-node])]

    (defn dfs [current-node]
      (when current-node
        (println (str "Visiting node: " (:name current-node)))
        (if (:find_me current-node)
          (println "Found the target node with value true!")
          (doseq [edge all_edges
                  :when (= (:node_from edge) (:name current-node))
                  :let [next-node (first (filter #(= (:name %) (:node_to edge)) all_nodes))]
                  :when (not (contains? visited next-node))]
            (dfs next-node))))
      )
    (dfs start-node))
  )

(dfs-search (first all_nodes))

