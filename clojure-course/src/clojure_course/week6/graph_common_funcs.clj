(ns clojure-course.week6.graph_common_funcs)

(defn get_node
  [node_name
   all_nodes
   ]
  (first (filter #(= node_name (:name %)) all_nodes))
  )

(defn get_edges_for_node
  [node
   all_edges]
  (filter #(or (= (:name node) (:node1 %)) (= (:name node) (:node2 %))) all_edges)
  )

(defn get_another_node_for_edge
  [this_node
   edge
   all_nodes
   ]
  (cond
    (= (:name this_node) (:node1 edge)) (get_node (:node2 edge) all_nodes)
    :else (get_node (:node1 edge) all_nodes)
    )
  )
