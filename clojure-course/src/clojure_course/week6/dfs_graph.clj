(ns clojure-course.week6.dfs-graph
  (:require [clojure-course.week6.graph_init_data :as graph])
  (:require [clojure-course.week6.graph_common_funcs :as funcs])
  )

(defn dfs-graph
  [; some node
   current_node
   ; global collection for all nodes
   all_nodes
   ; global collection for all edges
   all_edges
   ; global collection for visited nodes
   visited]
  (println (:name current_node) "is visited")
  ;(println "visited="visited)
  (let [edges (funcs/get_edges_for_node current_node all_edges)
        ]
    (doseq [edge edges
            :let [child_node (funcs/get_another_node_for_edge current_node edge all_nodes)]
            :when (not (.contains visited (:name child_node)))
            ]
      (println "edge=" (:node1 edge) "<->" (:node2 edge)" Let's go to" (:name child_node))
      (dfs-graph child_node all_nodes all_edges (conj visited (:name current_node)))
      )
    )









  ; read these conditions from top to bottom

  )

(dfs-graph (funcs/get_node "A" graph/all_nodes) graph/all_nodes graph/all_edges [])

; for debug
;(println "another node=" (funcs/get_another_node_for_edge (funcs/get_node "A" graph/all_nodes) (get graph/all_edges 0) graph/all_nodes))

;(println "edges=" (funcs/get_edges_for_node (funcs/get_node "A" graph/all_nodes) graph/all_edges))



