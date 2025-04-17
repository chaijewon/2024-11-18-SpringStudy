/* axios공통으로 사용 */
export default axios.create({
   baseURL:"http://localhost:8080/web",
   headers:{
      "Content-Type":"application/json"
   }
})