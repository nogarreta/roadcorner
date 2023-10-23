command to add the graphql schemas to the project

.\gradlew :app:downloadApolloSchema --endpoint="https://countries.trevorblades.com/graphql" --schema="./app/src/main/graphql/com/travelappoctober2023/schema.graphqls"

see build.gradle to see the dep configurations