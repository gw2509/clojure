(ns interest-is-interesting)

(defn interest-rate
  "Returns the interest rate based on the specified balance."
  [balance]
  (cond
    (neg? balance) -3.213
    (< balance 1000) 0.5
    (< balance 5000) 1.621
    :else 2.475))

(defn- calculate-interest
  [balance]
  (-> (interest-rate balance)
      (/ 100)
      bigdec
      (* (abs balance))))

(defn annual-balance-update
  "Returns the annual balance update, taking into account the interest rate."
  [balance]
  (-> balance
      calculate-interest
      (+ balance)))

(defn amount-to-donate
  "Returns how much money to donate based on the balance and the tax-free percentage."
  [balance tax-free-percentage]
  (->> (/ tax-free-percentage 100)
       (* balance 2)
       int
       (max 0)))

;(ns interest-is-interesting)
;
;(defn interest-rate
;  "Returns the interest rate based on the specified balance."
;  [balance]
;  (cond
;    (neg? balance) -3.213
;    (< balance 1000M) 0.5
;    (< balance 5000M) 1.621
;    :else 2.475))
;
;(defn calculate-interest
;  [balance]
;  (if (neg? balance)
;    (-> (bigdec (interest-rate balance))
;        (/ 100M)
;        (* (+ 1M (abs balance))))
;    (-> (interest-rate balance)
;        (/ 100M)
;        (* (abs balance)))))
;
;
;(defn annual-balance-update
;  [balance]
;  (-> balance calculate-interest (* balance)))
;
;(defn annual-balance-update
;  "Returns the annual balance update, taking into account the interest rate."
;  [balance]
;  (let [rate (interest-rate balance)]
;    (if (neg? balance)
;      (* balance (+ 1M (/ (bigdec (Math/abs rate)) 100M)))
;      (+ balance (* balance (/ (bigdec rate) 100M))))))
;
;;(defn amount-to-donate
;;  "Returns how much money to donate based on the balance and the tax-free percentage."
;;  [balance tax-free-percentage]
;;  (if (pos? balance)
;;    (int (* 2M balance (/ (bigdec tax-free-percentage) 100M)))
;;    0))
;
;(defn amount-to-donate
;  "Returns how much money to donate based on the balance and the tax-free percentage."
;  [balance tax-free-percentage]
;  (->> (/ tax-free-percentage 100)
;       (* balance 2)
;       int
;       (max 0)))