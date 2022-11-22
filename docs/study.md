## fork한 저장소에 원래 저장소의 최신 커밋 받아오기
### 1. fork한 저장소에 원래 저장소를 remote로 등록하기(최초 1회)
1. __원격 저장소 확인__
```
$ git remote -v
```
* 위 명령어 입력 시 다음과 같은 결과를 출력합니다. 이는 아직 원격 저장소 미설정 상태입니다.
```
origin https://github.com/YOUR_USERNAME/YOUR_FORK.git (fetch)
origin https://github.com/YOUR_USERNAME/YOUR_FORK.git (push)
```
* 원격 저장소에 원본 저장소를 설정해야, 원본 저장소에서 최신 수정 내역들을 fork한 저장소에 반영할 수 있고, PR을 날리는 등 다른 사람들과의 협업이 가능합니다.

2. __원격 저장소 등록__
```
$ git remote add REMOTE_NAME https://github.com/ORIGIN_OWNER/ORIGIN_REPO.git
```
* 위 명령어는 __이름을__ `REMOTE_NAME` __으로 하는 원격 저장소를 추가__ 합니다.
  * 원격 저장소 등록 과정은 최초 1회만 하면 됩니다.
  
### 2. 원격 저장소에서 최신 커밋 받아오기
1. __원격 저장소 확인__
```
$ git remote -v
```
* 아래와 같이 origin 뿐만 아니라 `REMOTE_NAME`이라는 이름으로 결과가 나온다면 정상적으로 등록된 것입니다.
```
origin https://github.com/YOUR_USERNAME/YOUR_FORK.git (fetch)
origin https://github.com/YOUR_USERNAME/YOUR_FORK.git (push)
REMOTE_NAME  https://github.com/ORIGIN_OWNER/ORIGIN_REPO.git (fetch)
REMOTE_NAME  https://github.com/ORIGIN_OWNER/ORIGIN_REPO.git (push)
```

2. __로컬 저장소의 default 브랜치로 변경__
```
$ git checkout main
```

3. __원격 저장소에서 최신 커밋 받아오기__
* 사용 명령어
  * `fetch`: 최신 커밋 내역을 가져온다. merge는 하지 않는다.
  
  * `pull`: 최신 커밋 내역을 가져오고, 로컬 저장소(내 저장소)에 merge 까지 자동으로 해 준다.
```
$ git fetch REMOTE_NAME
```

4. __로컬 저장소에 받아온 커밋 반영__
```
$ git merge REMOTE_NAME/main
```
* 변경 사항을 fork 저장소에 최종 반영하려면 `git push origin main`를 입력하여 푸쉬합니다.

해당 내용은 아래 두 링크를 참조했습니다.
* https://chanhuiseok.github.io/posts/git-2/
* https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/syncing-a-fork


