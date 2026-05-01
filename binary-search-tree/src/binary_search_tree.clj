(ns binary-search-tree)


(defrecord Tree [data left right])


(defn value [t]
  (:data t))


(defn singleton [data]
  (Tree. data nil nil))


(defn insert [data t]
  (let [val (:data t)
        dir (if (<= data val) :left :right)]
    (assoc t dir
             (if (nil? (dir t))
               (singleton data)
               (insert data (dir t))))))


(defn left [t]
  (:left t))


(defn right [t]
  (:right t))


(defn to-list [t]
  (when t
    (concat
      (to-list (:left t))
      [(:data t)]
      (to-list (:right t)))))


(defn from-list [l]
  (when (seq l)
    (reduce #(insert %2 %1)
      (singleton (first l))
      (rest l))))

