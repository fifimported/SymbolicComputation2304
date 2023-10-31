(ns clojure-course.week6.bfs-graph
  (:require [clojure-course.week6.graph_init_data :as graph])
  (:require [clojure-course.week6.graph_common_funcs :as funcs])
  )

; global collection for visited nodes
(def visited (atom []))

(defn bfs_graph
  [
   ; some nodes on the given iteration
   nodes
   ; global collection for all nodes
   all_nodes
   ; global collection for all edges
   all_edges
   ]
  ; firstly visit all nodes on the same level
  (doseq [current_node nodes
          :let [node_name (:name current_node)]
          :when (not (.contains @visited node_name))]
    (println node_name "is visited")
    (swap! visited conj node_name)
    )
  ; then traverse every node children
  (doseq [current_node nodes]
    (let [edges (funcs/get_edges_for_node current_node all_edges)
          children (funcs/get_children_for_node (:name current_node) edges all_nodes)
          ]
        (bfs_graph children all_nodes all_edges)
      )
    )
  )

(println "BFS DEMO")
(println "----------")
(bfs_graph (vector (funcs/get_node "A" graph/all_nodes)) graph/all_nodes graph/all_edges)


;DEBUG
;(println "children=" (funcs/get_children_for_node "A" graph/all_edges graph/all_nodes))



