(defproject material-reagent "0.1.0-SNAPSHOT"
  :description "Another shot at a reagent wrapper for material-ui"
  :url "https://github.com/raxod502/minimal-webapp"
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"}

  :dependencies [;; Language
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.93"]

                 ;; Server
                 [compojure "1.5.1"]
                 [hiccup "1.0.5"]
                 [ring/ring-jetty-adapter "1.5.0"]

                 ;; Client
                 [reagent "0.5.1"]

                 ;; Emacs integration
                 [com.cemerick/piggieback "0.2.1"]
                 [figwheel-sidecar "0.5.4-7"]]

  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-figwheel "0.5.4-7"]]

  :cljsbuild {:builds [{:id "main"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main "material-reagent.pages.splash"
                                   :output-to "resources/public/js/main.js"
                                   :output-dir "resources/public/js/out"
                                   :asset-path "js/out"}}]}
  :figwheel {:ring-handler material-reagent.server/site}

  :clean-targets ^{:protect false} ["resources/public" "target"]

  :uberjar-name "material-reagent-standalone.jar"
  :profiles {:uberjar {:aot :all
                       :main minimal-webapp.server
                       :hooks [leiningen.cljsbuild]}})
