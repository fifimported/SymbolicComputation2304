(ns clojure-course.week3.graph-of-might-magic)

(defrecord Node [name processed min_weight from])
(defrecord Edge [node1 node2 weight])

; TODO use infinity ##Inf
(def infinity 10000)

(def all_nodes
  (atom [
         (Node. "ORE_MINE" false infinity nil)
         (Node. "TAVERN" false infinity nil)
         (Node. "BLACKSMITH" false infinity nil)
         (Node. "WELL" false infinity nil)
         (Node. "HOUSE" false infinity nil)
         (Node. "STATUE" false infinity nil)
         (Node. "CHURCH" false infinity nil)
         (Node. "FOUNDRY" false infinity nil)
         ])
  )

(def all_edges
  [
   (Edge. "ORE_MINE" "TAVERN" 2)
   (Edge. "ORE_MINE" "BLACKSMITH" 9)
   (Edge. "TAVERN" "WELL" 3)
   (Edge. "BLACKSMITH" "WELL" 4)
   ;(Edge. "TAVERN" "HOUSE" 5)
   ;(Edge. "HOUSE" "STATUE" 6)
   ;(Edge. "WELL" "STATUE" 6)
   ;(Edge. "WELL" "CHURCH" 8)
   ;(Edge. "STATUE" "FOUNDRY" 4)
   ]
  )

(defn all_processed?
  []
  (= (count @all_nodes) (count
                   (filter #(true? (:processed %)) @all_nodes)
                   )
    )
  )

(defn get_node
  [node_name]
  ;(println "node_name:" node_name)
  ;(println "nodes filtered:" (filter #(= node_name (:name %)) nodes))
  (first (filter #(= node_name (:name %)) @all_nodes))
  )

(defn get_node_index
  [node nodes]
  ;(keep-indexed #(= node_name (:name %)) nodes)
  ;(.indexOf nodes "two")
  )

(defn get_edges_for_node
  [node_name]
  (filter #(or (= node_name (:node1 %)) (= node_name (:node2 %))) all_edges)
  )

(defn get_edge_next_node_name
  [node_name, edge]
  (if (= node_name (:node1 edge))
    (str (:node2 edge))
    (str (:node1 edge))
    )
  )

(defn compare_weight
  [assigned_weight new_weight]
  (if (< new_weight assigned_weight)
    (int new_weight)
    ; basically, we change nothing
    (int assigned_weight)
    )
  )

(defn print_processed_nodes
  []
  (let [processed_nodes (filter #(true? (:processed %)) @all_nodes)]
    (print "processed: ")
    (doseq [nd processed_nodes]
      (print (:name nd) "(" (:min_weight nd) ")" " | ")
      )
    (println)
    )
  )

(defn process_node
  [node_name node_name_from]
  (when-not (all_processed?)
    (let [node (get_node node_name)
          node_position (.indexOf @all_nodes node)
          ;_ (println node)
          ;_ (println "node_name=" (:name node) "processed=" (:processed node) "index=" node_position)
          edges_for_node (get_edges_for_node node_name)
          ;_ (println edges_for_node)
          node_from (get_node node_name_from)
          ; change this node properties
          updated_node (assoc node
                         :processed true
                         :min_weight (compare_weight (:min_weight node_from) (:min_weight node)))
          ;_ (println "node=" (:name updated_node) "; processed=" (:processed updated_node))
          updated_nodes (assoc @all_nodes node_position updated_node)
          _ (reset! all_nodes updated_nodes)
          ;_ (println updated_nodes)
          ;_ (println all_nodes)
          _ (print_processed_nodes)
          ]

          (doseq [edge edges_for_node]
            ; recursively run the same function for each node
            (let [next_node_name (get_edge_next_node_name node_name edge)
                  next_node (get_node next_node_name)
                  ]
              ; if the next node is processed, we don't go there
              (when (false? (:processed next_node))
                  (println "run edge. from=" node_name "; go to=" next_node_name)
                  (process_node next_node_name node_name)
                )
              )
            )
      )
    )
  )

(def start_node "ORE_MINE")
(def finish_node "FOUNDRY")
(process_node start_node start_node)



