export default axios.create({
    baseURL:"http://localhost:8080/web",
    headers:{
        "Content-Type":"application/json"
    }
})
